package bshow.util.ober;

import bshow.util.MyReplace;

public interface Subject {
	public void addLooker(Looker looker);
	public void removeLooker(Looker looker);
	public void notifyAllLooker(MyReplace mr);
}
