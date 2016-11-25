public class Knight extends Character{
	public Knight(){
		super(new SwordBehavior());
	}

	public Knight(WeaponBehavior w){
		super(w);
	}
	
	public void fight(){
		//System.out.println("Shickkk");
		super.weapon.useWeapon();
	}
}