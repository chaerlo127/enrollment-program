package constants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public final class Conflg {//final 상수로서 값을 변경하지 못함. 
	//symbol과 의미에 관해서 variable 을 쓰면 변경할 수 있는 것이고, constant는 변경을 하지 못하는 것
	//symbol, 의미와 값이 변하지 않고 일정하면 constant
	//symbol, 의미와 값이 변하는 것이 variable
	//size location의 값을 저장하는 곳
	//메모리 위치의 값이 변하지 않는다. 
	public static class FVMainFrame{//F가 붙으면 conflg
		public static final Point location =new Point(300, 100);
		//location 단어는 좌표 200 300으로 고정시켜놓을 것이다. 
		//vmain frame의 location이 되는 것이다. 
		//이름을 만들 때에는 이름이 동일해도 상관은 없음. 온점을 통해서 이루어져서 name space가 다르기 때문이다. 
		public static final Dimension size = new Dimension(800, 600);
	}
	public static class FVMainPanel
	{
		public static final Color background = Color.white;
	}
	
	public static class FVHwewonDeungrok
	{
		public static final Point location =new Point(300, 100);
		public static final Dimension size = new Dimension(400, 400);
	}
	
	public static class FVCampus
	{
		public static final String FirstFileName = "root";
	}

}
