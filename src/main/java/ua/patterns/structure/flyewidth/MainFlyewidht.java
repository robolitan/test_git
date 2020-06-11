package ua.patterns.structure.flyewidth;

public class MainFlyewidht {
    public static void main(String[] args) {
        FabricWithFlyewidht fabricWithFlyewidht = new FabricWithFlyewidht();
        System.out.println(fabricWithFlyewidht.getItem(new Computer("33")));
        System.out.println(fabricWithFlyewidht.getItem(new Computer("33333")));
        System.out.println(fabricWithFlyewidht.getItem(new Mouse("33333")));
        System.out.println(fabricWithFlyewidht.getItem(new Computer("33333")));
    }
}
