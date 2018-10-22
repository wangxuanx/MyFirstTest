package gamelife;

public class Controller {
	CellularArray C=new CellularArray(17, 27);
	
	public void getNum() {           //����������
		setZero();
		
		int x,y;
		for(int i=0;i<60;i++) {
			x=(int) Math.floor(Math.random() * 17);          // �ɾ����ȡ1��17�����������
			y=(int) Math.floor(Math.random() * 27);          // �ɾ����ȡ1��27�����������
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
