public class main extends JFrame  implements ActionListener {

Container panel;

	

	JButton movie_rank,theme_movie,movie_view,Exit;

	JLabel title_Jlabel;
	JLabel Jname_Jlabel;
	JLabel Wname_Jlabel;
	JLabel Jmvr_Jlabel = new JLabel(parse.movie_rank());
	JScrollPane js ;
	JTextField txt;
	
	
String a;	
	JTextArea txta;
	JPanel pan1_title;
	JPanel pan2_btn;
	JPanel pan3_name;
	JPanel pan4_movie_rank;
	JPanel pan5_theme_movie;
	
	//버튼 액션 메소드
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==movie_rank){txta.setText(Jmvr_Jlabel.getText());}//**문제점 : 스크롤이 안됨

		if(e.getSource()==theme_movie){}

		if(e.getSource()==movie_view){}
		
		if(e.getSource()==Exit){ }
			
	}

	main() {
		

		pan1_title = new JPanel();
		pan2_btn = new JPanel();
		pan3_name = new JPanel();
		pan4_movie_rank = new JPanel();

		setLayout(new BorderLayout());

		txta = new JTextArea();

		add(pan1_title,BorderLayout.NORTH);
		add(pan2_btn, BorderLayout.WEST);
		add(pan3_name,BorderLayout.SOUTH);
		add(txta, BorderLayout.EAST);


		// pan1_title 레이아웃 구성 --타이틀
		
		title_Jlabel = new JLabel("영화 뭐보지???");

		pan1_title.add(title_Jlabel);

		pan1_title.setBackground(Color.PINK);
		
		//pan1 레이아웃 구성 끝
		
		add(txta);
		txta.setBackground(Color.RED);
	
		// pan2 레이아웃 구성  --버튼

		movie_rank = new JButton("실시간 영화 순위");
		theme_movie = new JButton("장르별 영화 순위");
		movie_view = new JButton("시청하시겠습니까?");
		
		pan2_btn.add(movie_rank);
		pan2_btn.add(theme_movie);
		pan2_btn.add(movie_view);
		
		pan2_btn.setBackground(Color.WHITE);
		
		// pan2 레이아웃 구성 끝
		
		//pan3 레이아웃 구성 -- 이름 학번
	
		Jname_Jlabel = new JLabel("20207 권예준");
		Wname_Jlabel = new JLabel("20209 김용완");
		Exit = new JButton(":: 나가기 ::");
		pan3_name.add(Jname_Jlabel);
		pan3_name.add(Wname_Jlabel);
		pan3_name.add(Exit);
		pan3_name.setBackground(Color.PINK);
		
		//pan3 레이아웃 구성 끝
		
		this.setSize(650, 500);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		movie_rank.addActionListener(this);
		theme_movie.addActionListener(this);
		movie_view.addActionListener(this);

	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new main();

	}

}
