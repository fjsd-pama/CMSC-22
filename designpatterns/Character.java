public abstract class Character{
	protected WeaponBehavior weapon;
	abstract void fight();

	public Character(WeaponBehavior w){
		setWeapon(w);
	}
	
	void setWeapon(WeaponBehavior w){
		this.weapon = w;
	}
}