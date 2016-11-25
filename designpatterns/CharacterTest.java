public class CharacterTest{

	public static void main( String[] args ){
		King kk = new King();
		System.out.println("== KING ==");
		kk.fight();
		kk.setWeapon(new AxeBehavior());
		kk.fight();

		Queen qqn = new Queen();
		System.out.println("\n== QUEEN ==");
		qqn.fight();
		qqn.setWeapon(new AxeBehavior());
		qqn.fight();

		Knight kn = new Knight();
		System.out.println("\n== KNIGHT ==");
		kn.fight();
		kn.setWeapon(new AxeBehavior());
		kn.fight();

		Troll tr = new Troll();
		System.out.println("\n== TROLL ==");
		tr.fight();
		tr.setWeapon(new AxeBehavior());
		tr.fight();
	}
}