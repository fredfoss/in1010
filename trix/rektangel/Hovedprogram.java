// Hovedprogram
class Hovedprogram {
    
    public static void main(String[] args) {
        
        Rektangel rektangel1 = new Rektangel(4, 9);
        Rektangel rektangel2 = new Rektangel(11, 15);

        System.out.println(rektangel1.areal());
        System.out.println(rektangel2.areal());

        rektangel1.oekLengde(3);
        rektangel2.oekBredde(20);

        System.out.println(rektangel1.omkrets());
        System.out.println(rektangel2.omkrets());
    }
}
