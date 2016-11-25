public class King extends Character{
	public King(){
		super(new KnifeBehavior());
	}

	public King(WeaponBehavior w){
		super(w);
	}
	
	public void fight(){
		//System.out.println("Whook");
		super.weapon.useWeapon();
	}

}