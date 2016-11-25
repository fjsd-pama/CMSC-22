public class Troll extends Character{
	public Troll(){
		super(new AxeBehavior());
	}
	
	public Troll(WeaponBehavior w){
		super(w);
	}
	
	public void fight(){
		//System.out.println("Shickkk");
		super.weapon.useWeapon();
	}
}