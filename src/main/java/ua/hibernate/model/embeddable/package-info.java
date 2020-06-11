@org.hibernate.annotations.FetchProfiles({
    /*
        Each profile has a name, this is a simple string we have isolated in a constant.
     */
        @FetchProfile(name = Actor.PROFILE_JOIN_SELLER,
                /*
                     Each override in a profile names one entity association or collection.
                 */
                fetchOverrides = @FetchProfile.FetchOverride(
                        /*
                              The only supported mode at the time of writing is <code>JOIN</code>.
                         */
                        entity = Actor.class,
                        association = "map",
                        mode = FetchMode.JOIN
                )),
        @FetchProfile(name = Actor.PROFILE_JOIN_BIDS,
                fetchOverrides = @FetchProfile.FetchOverride(
                        entity = Actor.class,
                        association = "map",
                        mode = FetchMode.JOIN
                ))
})

package ua.hibernate.model.embeddable;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;
import ua.hibernate.model.Actor;