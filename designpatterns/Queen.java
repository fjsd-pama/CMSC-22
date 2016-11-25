public class Queen extends Character{
	public Queen(){
		super(new BowAndArrowBehavior());
	}

	public Queen(WeaponBehavior w){
		super(w);
	}
	
	public void fight(){
		//System.out.println("Thwaack... Thud");
		super.weapon.useWeapon();
	}
}