package gamelife;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

public class Main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7940630133208953277L;
	private JPanel contentPane;
	Controller Co=new Controller();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("\u521D\u59CB\u5316\u7EC6\u80DE");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u7EC6\u80DE\u6E05\u96F6");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5355\u6B21\u7E41\u884D");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u91CD\u590D\u7E41\u884D");
		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel(){
            /**
			 * 
			 */
			private static final long serialVersionUID = -5664732593808163945L;

			// 重写paint方法
            @Override
            public void paint(Graphics graphics) {
                // 必须先调用父类的paint方法
                super.paint(graphics);
                
                for(int i=0;i<28;i++) {
                	graphics.drawLine(20+20*i, 20, 20+20*i, 360);
                }
                for(int j=0;j<18;j++) {
                	graphics.drawLine(20, 20+20*j, 560,20+20*j );
               }
                
            }
        };
        contentPane.add(panel_1, BorderLayout.CENTER);
		
		btnNewButton.addActionListener(new ActionListener() {              //随机细胞点击事件
			public void actionPerformed(ActionEvent arg0) {
				Co.getNum();
				
				JPanel panel_2 = new JPanel(){
		            // 重写paint方法
		            @Override
		            public void paint(Graphics graphics) {
		                // 必须先调用父类的paint方法
		                super.paint(graphics);
		                
		                for(int i=0;i<28;i++) {
		                	graphics.drawLine(20+20*i, 20, 20+20*i, 360);
		                }
		                for(int j=0;j<18;j++) {
		                	graphics.drawLine(20, 20+20*j, 560,20+20*j );
		               }
		               for(int i=0;i<17;i++) {
		            	   for(int j=0;j<27;j++) {
		            		   if(Co.C.getCell(i, j) == true) {
		            			   graphics.fillRect(20*(j+1), 20*(i+1), 20, 20);
		            		   }
		            	   }
		               	}	
		            }
		        };
		        panel_2.setBounds(0, 0, panel_1.getWidth(), panel_1.getHeight());
		        panel_2.setVisible(true);
		        panel_1.add(panel_2);
		        panel_1.repaint();
		        
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {           //细胞清零点击事件
			public void actionPerformed(ActionEvent arg0) {
				Co.setZero();
				
				JPanel panel_2 = new JPanel(){
					// 重写paint方法
		            @Override
		            public void paint(Graphics graphics) {
		                // 必须先调用父类的paint方法
		                super.paint(graphics);
		                
		                for(int i=0;i<28;i++) {
		                	graphics.drawLine(20+20*i, 20, 20+20*i, 360);
		                }
		                for(int j=0;j<18;j++) {
		                	graphics.drawLine(20, 20+20*j, 560,20+20*j );
		               }
		                
		            }
		        };
		        panel_2.setBounds(0, 0, panel_1.getWidth(), panel_1.getHeight());
		        panel_2.setVisible(true);
		        panel_1.add(panel_2);
		        panel_1.repaint();
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {                  //单次繁衍按钮事件
			public void actionPerformed(ActionEvent arg0) {
				GrowCell();            //单次繁衍
				
				JPanel panel_2 = new JPanel(){
					// 重写paint方法
		            @Override
		            public void paint(Graphics graphics) {
		                // 必须先调用父类的paint方法
		               super.paint(graphics);
		               
		               for(int i=0;i<28;i++) {
		                	graphics.drawLine(20+20*i, 20, 20+20*i, 360);
		                }
		                for(int j=0;j<18;j++) {
		                	graphics.drawLine(20, 20+20*j, 560,20+20*j );
		               }
		               for(int i=0;i<17;i++) {
		            	   for(int j=0;j<27;j++) {
		            		   if(Co.C.getCell(i, j) == true) {
		            			   graphics.fillRect(20*(j+1), 20*(i+1), 20, 20);
		            		   }
		            	   }
		               	}	
		            }
		        };
		        panel_2.setBounds(0, 0, panel_1.getWidth(), panel_1.getHeight());
		        panel_2.setVisible(true);
		        panel_1.add(panel_2);
		        panel_1.repaint();
			}
		});
		
		
		btnNewButton_3.addActionListener(new ActionListener() {              //多次繁衍按钮事件
			public void actionPerformed(ActionEvent arg0) {
				Timer timer=new Timer();//实例化Timer类 
				if(btnNewButton_3.getText().equals("重复繁衍")) {
					btnNewButton_3.setText("结束繁衍");
					 
					timer.schedule(new TimerTask() {
					@Override
					public void run() {
						GrowCell();
						
						JPanel panel_2 = new JPanel(){
							// 重写paint方法
				            @Override
				            public void paint(Graphics graphics) {
				                // 必须先调用父类的paint方法
				               super.paint(graphics);
				               for(int i=0;i<28;i++) {
				                	graphics.drawLine(20+20*i, 20, 20+20*i, 360);
				                }
				                for(int j=0;j<18;j++) {
				                	graphics.drawLine(20, 20+20*j, 560,20+20*j );
				               }
				               for(int i=0;i<17;i++) {
				            	   for(int j=0;j<27;j++) {
				            		   if(Co.C.getCell(i, j) == true) {
				            			   graphics.fillRect(20*(j+1), 20*(i+1), 20, 20);
				            		   }
				            	   }
				               	}	
				            }
				        };
				        panel_2.setBounds(0, 0, panel_1.getWidth(), panel_1.getHeight());
				        panel_2.setVisible(true);
				        panel_1.add(panel_2);
				        panel_1.repaint();
					}}, 200, 500);           //五百毫秒  
				} else {
					timer.cancel();
					btnNewButton_3.setText("重复繁衍");
				}
			
			}
			
		});
		
	}
	
	public void GrowCell() {                       //细胞繁衍函数
		int i,j;
		int[][] back=new int[18][28];
		
		for(i=0;i<17;i++) {
			for(j=0;j<27;j++) {
				back[i][j] = Co.C.cells[i][j];
			}
		}
		
		for(i=0;i<17;i++) {               //遍历细胞确定生与死
			for(j=0;j<27;j++) {
				int num=0;
				
				if (i - 1 >= 0 && j - 1 >= 0) {                 //左上角不越界
					if(back[i - 1][j - 1] == 1) { num++; }
				}
				if (i - 1 >= 0) {                 //正上方
					if(back[i - 1][j] == 1) { num++; }
				}
				if (i - 1 >= 0 && j + 1 < 27) {           //右上角
					if(back[i - 1][j + 1] == 1) { num++; }
				}
				if (j + 1 < 27) {            //正右方
					if(back[i][j + 1] == 1) { num++; }
				}
				if (i + 1 < 17 && j + 1 < 27) {             //右下角
					if(back[i + 1][j + 1] == 1) { num++; }
				}
				if (i + 1 < 17) {              //正下方
					if(back[i + 1][j] == 1) { num++; }
				}
				if (i + 1 < 17 && j - 1 >= 0) {              //左下角
					if(back[i + 1][j - 1] == 1) { num++; }
				}
				if (j - 1 >= 0) {                    //正左方
					if(back[i][j - 1] == 1) { num++; }
				}
				
				if(Co.C.cells[i][j] == 1) {             //cells[i][j]如果有细胞
					if(num<2) {
						Co.C.setCellDead(i, j);
					}else if(num > 3) {
						Co.C.setCellDead(i, j);
					}
				}else if(Co.C.cells[i][j] == 0){             //i.j处无细胞
					if(num == 3)
						Co.C.setCellAlive(i, j);
				}
							
			}
		}
	}
}
