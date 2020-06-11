package ua.jndi;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiTemplate;

import javax.naming.*;
import java.util.Hashtable;
import java.util.Properties;

public class MainJndi {
    static String DNS_CONTEXT = "com.sun.jndi.dns.DnsContextFactory";
    static String DNS_URL     = "dns://77.88.8.8"; // yandex

    public static void main(String[] args) throws NamingException {
        new MainJndi();
        System.exit(0);
    }

    public MainJndi() throws NamingException {
        JndiTemplate jndiTemplate = new JndiTemplate();
        InitialContext ctx = (InitialContext) jndiTemplate.getContext();
        ctx.lookup("java:/DefaultDS");

    }
}

