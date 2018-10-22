package gamelife;

public class Controller {
	CellularArray C=new CellularArray(17, 27);
	
	public void getNum() {           //获得随机数据
		setZero();
		
		int x,y;
		for(int i=0;i<60;i++) {
			x=(int) Math.floor(Math.random() * 17);          // 可均衡获取1到17的随机整数。
			y=(int) Math.floor(Math.random() * 27);          // 可均衡获取1到27的随机整数。
			C.setCellAlive(x, y);
		}
	}
	
	public void setZero() {
		for(int i=0;i<17;i++) {
			for(int j=0;j<27;j++) {
				C.cells[i][j]=0;
			}
		}
	}
}
