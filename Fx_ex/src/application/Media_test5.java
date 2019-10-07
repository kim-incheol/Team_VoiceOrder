package application;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import application.PlayMusicTest;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;



public class Media_test5 extends JFrame{
   // 프레임 생성
   JFrame frame1 = new JFrame();
      JFrame frame2 = new JFrame();
      JFrame frame3 = new JFrame();
      JFrame frame4 = new JFrame();
      
      private JTextField searchText;
      
      // 버튼 생성
      JButton title;
      JButton p_list_title;
      JButton find_music;
    JButton start_music;
    JButton pause_music;
    JButton stop_music;
    JButton front_music;
    JButton back_music;
    JButton p_all;
    JButton p_mylist;
    
    JButton shuffle_music;
    JButton replay_music;
    JButton back_frame;
    
    // 라벨생성
    JLabel now_music_play;
    JLabel play_main;
    
    
    // 이미지 생성
    ImageIcon find_music_img = new ImageIcon("image/find_music.png");
    ImageIcon play_main_img = new ImageIcon(new ImageIcon("image/test.jpg").getImage().getScaledInstance(350, 320, Image.SCALE_DEFAULT));
    ImageIcon start_music_img = new ImageIcon("image/start.png");
    ImageIcon stop_music_img = new ImageIcon("image/stop.png");
    ImageIcon front_music_img = new ImageIcon("image/front.png");
    ImageIcon back_music_img = new ImageIcon("image/back.png");
    ImageIcon shuffle_on_music_img = new ImageIcon("image/shuffle_on.png");
    ImageIcon shuffle_off_music_img = new ImageIcon("image/shuffle_off.png");
    ImageIcon replay_music_img = new ImageIcon("image/replay.png");
    ImageIcon back_frame_img = new ImageIcon("image/back_frame.png");
    ImageIcon once_play_img = new ImageIcon("image/once_play.png");
    ImageIcon pause_music_img = new ImageIcon("image/pause.png");
    
    
    String[] songArr = {"기억해줘요 내 모든 날과 그때를-거미","그대라는 시-태연","오늘도 빛나는 너에게-마크툽","내 맘을 볼수 있나요-헤이즈","술이 문제야-장혜진윤민수","니소식-송하예",
            "포장마차-황인욱","헤어져줘서 고마워-벤","그 끝에 그대-청하","사랑에 연습이 있었다면-임재현","ICY-ITZY","2002-AnneMarie","나의 어깨에 기대어요-10cm","뭐해-강다니엘",
            "솔직하게 말해서 나-김나영","인사-멜로망스","Speechless-Naomi Scott","괜찮아도 괜찮아-디오","사랑이 식었다고 말해도 돼-먼데이키즈","작은 것들을 위한 시-방탄소년단",
            "Snapping-청하","bad guy-Billie Eilish","Another Day-먼데이키즈펀치","We don't talk together-헤이즈","UN Village-백현","I HOPE-강다니엘",
            "Color-강다니엘","시든 꽃에 물을 주듯-박혜원","Horizon-강다니엘","사월이 지나면 우리 헤어져요-첸","BAND-창모(ChANGMO),HashSwan,ASHISLAND,김효은","너에게 못했던 내 마지막 말은-다비치",
            "Intro-강다니엘","Senorita-Camila Cabello,Shawn Mendes","너만 너만 너만-양다일","내 안부-이우","비가 내리는 날에는-윤하","What a life-세훈&찬열","Love Shot-EXO",
            "아퍼-기리보이","사계-태연","그때가 좋았어-케이시","노래방에서-장범준","있어 희미하게-세훈&찬열","모든 날, 모든 순간-폴킴","주저하는 연인들을 위해-잔나비","FANCY-TWICE(트와이스)","BOOM-NCT DREAM","부르면 돼-세훈&찬열",
            "Tempo-EXO","Goodbye-박효신","너를 만나-폴킴","Paris In The Rain-Lauv","파티피플-기리보이","사계-엠씨더맥스","A Whole New World-Mena Massoud, Naomi Scott","봄날-방탄소년단",
            "달라달라-ITZY","소우주-방탄소년단","IDOL-방탄소년단","서울 밤-어반자카파","비워-창모(ChANGMO),HashSwan,ASHISLAND,김효은,Leellamarz,The Quiett","나만, 봄- 볼빨간사춘기","Make it Right-방탄소년단",
            "비오는 날 뭐해-하은","옥탑방-엔플라잉","Dionysus-방탄소년단","U GOT IT-갓츄","벌써 12시-청하","돈 Call Me-염따","열대야-여자친구","대충 입고 나와-우디","조금 더 외로워 지겠지-김나영",
            "Believer-Imagine Dragons","넘쳐흘러-엠씨더맥스","Way Back Home-숀","비-폴킴","짐살라빔-레드벨벳","Stay Up-백현","선-세훈&찬열","누구 없소-이하이","롤러코스터-세훈&찬열","이별하러 가는 길-임한별",
            "Kill This Love-BLACKPINK","교통정리-기리보이","몽-세훈,찬열","사랑이 좀 어려워-NCTDREAM","이뻐이뻐-크레파스","STRONGER-NCT DREAM","헤어질 걸 알아-폴킴","UhOh-(여자)아이들","119-NCT DREAM","안녕-수란","진심이 담긴 노래-케이시(Kassy)",
            "별 보러 갈래-볼빨간사춘기","Best Friend-NCT DREAM","Betcha-백현","가라사대-비와이(BewhY)","180도-벤","comethru-Jeremy Zucker"};
    

    
    ImageIcon[] music_images = { new ImageIcon("music_images/기억해줘요내모든날과그때를-거미.jpg"),new ImageIcon("music_images/그대라는시-태연.jpg"),
            new ImageIcon("music_images/오늘도빛나는너에게-마크툽.jpg"),new ImageIcon("music_images/내맘을볼수있나요-헤이즈.jpg"),new ImageIcon("music_images/술이문제야-장혜진윤민수.jpg"),
            new ImageIcon("music_images/니소식-송하예.jpg"),new ImageIcon("music_images/포장마차-황인욱.jpg"),new ImageIcon("music_images/헤어져줘서고마워-벤.jpg"),
            new ImageIcon("music_images/그끝에그대-청하.jpg"),new ImageIcon("music_images/사랑에연습이있었다면-임재현.jpg")};

	
	

   
   Media_test5(){

	   
	   
      for(int i=0;i<music_images.length;i++) {
         music_images[i].getImage().getScaledInstance(350, 320, Image.SCALE_DEFAULT);
      }
        //@@@@@ 첫 번째 화면(Main) 프레임 @@@@@
         frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame1.setLayout(null);
         
         // 버튼 생성
         title = new JButton("Media_Player");
         
         title.addActionListener(new ActionButtonHandler1());
         title.setFont(new Font("Serif",Font.BOLD,25));
         
         // 버튼생성, 버튼기능, 버튼속성
         find_music = new JButton(find_music_img);
         find_music.setBackground(Color. white);
         find_music.addActionListener(new ActionButtonHandler5());
         
         // JLabel 생성
         JLabel music_chart_title = new JLabel("Music_Chart");
         music_chart_title.setFont(new Font("Serif",Font.BOLD,20));
         
         // JList 생성
         JList scrollList1 = new JList(songArr);
         
         // 패널 생성, m_panel(main_panel)
         JPanel m_panel1 = new JPanel();
         m_panel1.setLayout(new GridLayout(1,2,10,10));   
         m_panel1.setBounds(0, 0, 400, 60);
         JPanel m_panel2 = new JPanel();
         m_panel2.setBounds(100, 60, 200, 40);
         JPanel m_panel3 = new JPanel();
         m_panel3.setLayout(new GridLayout(1,1));
         m_panel3.setBounds(40, 120, 300, 350);
         
         // 패널 추가
         m_panel1.add(title);
         m_panel1.add(find_music);
         m_panel2.add(music_chart_title);
         m_panel3.add(new JScrollPane(scrollList1));
         
         frame1.add(m_panel1);
         frame1.add(m_panel2);
         frame1.add(m_panel3);
         frame1.setSize(400,600);
         frame1.setVisible(true);
         //@@@@@ 첫 번째 화면(Main) 프레임 @@@@@
         
        
         
         
         //@@@@@ 두 번째 화면(PlayList) 프레임 @@@@@
         frame2.setLayout(null);
         frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         // 현재 시간 표시
         SimpleDateFormat format1 = new SimpleDateFormat ("HH:mm");   
         Date time1 = new Date();   
         String time2 = format1.format(time1);
         
         JLabel time = new JLabel(time2);
         time.setFont(time.getFont().deriveFont(25.0f));
         time.setHorizontalAlignment(JLabel.CENTER);
         time.setBounds(0, 0, 110, 60);
         
         now_music_play = new JLabel();
         now_music_play.setFont(new Font("Serif",Font.BOLD,15));
         now_music_play.setBounds(0, 450, 200, 50);
         
         p_list_title = new JButton("재생목록");
         p_list_title.addActionListener(new ActionButtonHandler2());
         p_list_title.setFont(new Font("Serif",Font.BOLD,20));
         JList scrollList2 = new JList(songArr);
         scrollList2.addListSelectionListener(new JListHandler2(now_music_play));
         
         // 버튼생성, 버튼기능, 버튼속성
         find_music = new JButton(find_music_img);
         find_music.addActionListener(new ActionButtonHandler5());
         
         start_music = new JButton(start_music_img);
         start_music.addActionListener(new ActionButtonHandler_sp());
         start_music.setBounds(100, 503, 100, 60);
         start_music.setBackground(Color. white);
         
         stop_music = new JButton(stop_music_img);
         stop_music.setBounds(200, 503, 100, 60);
         stop_music.setBackground(Color. white);
        
         front_music = new JButton(front_music_img);
         front_music.setBounds(300, 503, 100, 60);
         front_music.setBackground(Color. white);
         
         back_music = new JButton(back_music_img);
         back_music.setBounds(0, 503, 100, 60);
         back_music.setBackground(Color. white);
          
         
         p_all = new JButton("곡");// 곡(100)형식으로 출력하기
         p_mylist = new JButton("플레이리스트");
         
         // 패널생성(list_panel), 패널 세팅, 패널추가
         JPanel l_panel1 = new JPanel();
         l_panel1.setBounds(110, 0, 280, 60);
         JPanel l_panel2 = new JPanel();
         l_panel2.setBounds(0, 60, 110, 80);
         JPanel l_panel3 = new JPanel();
         l_panel3.setBounds(110, 70, 280, 300);
         
         l_panel1.setLayout(new GridLayout(1,3));     
         l_panel2.setLayout(new GridLayout(2,1));
         l_panel3.setLayout(new GridLayout(1,1));         
         
         
         l_panel1.add(p_list_title);
         l_panel1.add(find_music);
         
         l_panel2.add(p_all);
         l_panel2.add(p_mylist);
         
         l_panel3.add(new JScrollPane(scrollList2));
         
         frame2.add(start_music);
         frame2.add(stop_music);
         frame2.add(front_music);
         frame2.add(back_music);
         frame2.add(time);
         frame2.add(now_music_play);
         frame2.add(l_panel1);
         frame2.add(l_panel2);
         frame2.add(l_panel3);
         frame2.setSize(400,600);
//       frame2.setVisible(true);
         //@@@@@ 두 번째 화면(PlayList) 프레임 @@@@@
         
         
         
         //@@@@@ 세 번째 화면(Play) 프레임 @@@@@ 
         frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame3.setLayout(null);      
         
         // 라벨 생성
         JLabel music_name = new JLabel("노래 제목");
         music_name.setFont(new Font("Serif",Font.BOLD,20));
         music_name.setHorizontalAlignment(JLabel.CENTER);
         
         JLabel music_singer = new JLabel("가수 이름");
         music_singer.setFont(new Font("Serif",Font.BOLD,10));
         music_singer.setHorizontalAlignment(JLabel.CENTER);

         
         play_main=new JLabel();
         play_main.setIcon(music_images[0]);
         play_main.setBounds(20, 50, 350, 320);
         
         JLabel play_lyrics = new JLabel("그리워서 한 잔" + " " + "생각나서 한 잔");   // 노래가사
         play_lyrics.setBounds(100, 370, 200, 50);
         
         // 슬라이더바 생성
         JSlider p_slider3 = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);   //0 부터,  100까지, 어디서 부터 시작할지
         p_slider3.setPaintLabels(true);
         p_slider3.setPaintTicks(true);
         p_slider3.setPaintTrack(true);
         p_slider3.setMajorTickSpacing(50);   // 큰 눈금
         p_slider3.setMinorTickSpacing(10);   // 작은 눈금
         p_slider3.setBounds(100, 450, 200, 50);
         
         // 버튼생성, 버튼기능, 버튼속성
         pause_music = new JButton(pause_music_img);
         pause_music.addActionListener(new ActionButtonHandler_sp());
         pause_music.setBounds(100, 503, 100, 60);
         pause_music.setBackground(Color. white);
         
         stop_music = new JButton(stop_music_img);
         stop_music.setBounds(200, 503, 100, 60);
         stop_music.setBackground(Color. white);
        
         front_music = new JButton(front_music_img);
         front_music.setBounds(300, 503, 100, 60);
         front_music.setBackground(Color. white);
         
         back_music = new JButton(back_music_img);
         back_music.setBounds(0, 503, 100, 60);
         back_music.setBackground(Color. white);
         
         shuffle_music = new JButton(shuffle_on_music_img);
         shuffle_music.addActionListener(new ActionButtonHandler_shuffle_onoff());
         shuffle_music.setBounds(310, 450, 40, 40);
         shuffle_music.setBackground(Color. white);
         
         replay_music = new JButton(replay_music_img);
         replay_music.addActionListener(new ActionButtonHandler_or());
         replay_music.setBounds(50, 450, 40, 40);
         replay_music.setBackground(Color. white);
         
         back_frame = new JButton(back_frame_img);
         back_frame.addActionListener(new ActionButtonHandler3());
         back_frame.setBounds(0, 0, 40, 40);
         back_frame.setBackground(Color. white);
         
         
         // 패널생성(play_panel), 패널세팅, 패널추가
         JPanel p_panel1 = new JPanel();
         JPanel p_panel2 = new JPanel();
         JPanel p_panel3 = new JPanel();
         
         p_panel1.setLayout(new GridLayout(2,1));
         p_panel1.setBounds(0, 0, 400, 50);
         p_panel2.setLayout(null);
         p_panel3.setLayout(null); 
         
         p_panel1.add(music_name);
         p_panel1.add(music_singer);
         
         frame3.add(back_music);
         frame3.add(pause_music);
         frame3.add(stop_music);
         frame3.add(front_music);
         
         frame3.add(back_frame);
         frame3.add(p_panel1);
         frame3.add(play_main);
         frame3.add(play_lyrics);
         frame3.add(shuffle_music);
         frame3.add(p_slider3);
         frame3.add(replay_music);
//       frame3.add(p_panel4);
         frame3.setSize(400,600);
         frame3.setVisible(false);
         //@@@@@ 세 번째 화면(Play) 프레임 @@@@@  //////////////////////////////////////////////////////////////////////////////////////
         
         
         /////////@@@ 네 번째 화면(Search) 프레임//////////////////////////////////////////////////////////////////////////////////////////
         frame4.setDefaultCloseOperation(EXIT_ON_CLOSE);
         frame4.setLayout(null);
         
         SimpleDateFormat format2 = new SimpleDateFormat ("HH:mm");   
        Date time3 = new Date();   
        String time4 = format2.format(time3);
         
         JLabel time5 = new JLabel(time4);
         time5.setFont(time.getFont().deriveFont(25.0f));
         time5.setHorizontalAlignment(JLabel.CENTER);
         time5.setBounds(0, 0, 110, 60);
         
       
 
         JLabel searchmusic =new JLabel("검색어를 입력해주세요.");
         searchmusic.setFont(new Font("Serif",Font.BOLD,15));
         searchmusic.setBounds(100,100,200,30);
        
         searchText=new JTextField(20);
         searchText.setBounds(60,160,220,30);
         
   
         JButton p_list_title2 = new JButton("재생목록");
         p_list_title2.addActionListener(new ActionButtonHandler1());
         p_list_title2.setFont(new Font("Serif",Font.BOLD,20));
         JList searchlist=new JList();
         
         JButton title2 = new JButton("Main");
         title2.addActionListener(new ActionButtonHandler2());
         title2.setFont(new Font("Serif",Font.BOLD,20));
         
         JPanel sl_panel =new JPanel(); // 검색결과창
         sl_panel.setBounds(60,200,280,300);
         DefaultListModel demoList = new DefaultListModel();
         JList searchlist1 = new JList(demoList);
         
         JButton searchButton=new JButton("검색");
         searchButton.setFont(new Font("Serif",Font.BOLD,8));
         searchButton.setBounds(290,160,50,30);

         searchButton.addActionListener(new ActionListener() {
           
            @Override
             public void actionPerformed(ActionEvent e) {
                String musicText= searchText.getText();
                searchButton.setText("검색");
                if(musicText.length()==0 ) {
                   JOptionPane.showMessageDialog(null, "검색어를 입력하지 않았습니다. 다시 입력해주세요. ",
                         musicText, JOptionPane.DEFAULT_OPTION);
                   return;
                   }
                //int count_list =0;
                int cnt = -1;
                for(int i=0;i<songArr.length;i++) {
                  if(searchText.getText().equals(songArr[i])) {
                     JOptionPane.showMessageDialog(null, "노래를 찾았습니다. ");
                     demoList.clear();
                     demoList.add(0, songArr[i]);
                     //count_list++;
                     searchText.setText("");
                     cnt ++;
                     //System.out.println(music[i]);
                     
                  }   
                
                }
                  if(cnt < 0) {
                     
                     demoList.clear();
                     searchText.setText("");
                     JOptionPane.showMessageDialog(null, "검색한 노래가 없습니다.");
                     
                  }
             }   
               
         });

         JPanel s_panel = new JPanel();  // 시간, 재생목록, main 버튼
         s_panel.setBounds(110, 0, 280, 60);
         
         s_panel.setLayout(new GridLayout(1,3));
         sl_panel.setLayout(new GridLayout(1,1));
         
         s_panel.add(p_list_title2);
         s_panel.add(title2);
         sl_panel.add(new JScrollPane(searchlist1));
   
         
         frame4.add(time5);
         frame4.add(s_panel);
         frame4.add(sl_panel);
         frame4.add(searchmusic);
         frame4.add(searchText);
         frame4.add(searchButton);
         frame4.setSize(400,600);
         frame4.setVisible(false);
         
         /////////@@@ 네 번째 화면(Search) 프레임///////////////////////////////////////////////////////////////////////////////////// 
   }
   
   class ActionButtonHandler_shuffle_onoff implements ActionListener{
      
      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         JButton btn=(JButton) e.getSource();   
            if(btn.getIcon().equals(shuffle_on_music_img)) {
               btn.setIcon(shuffle_off_music_img);             
            }
            else { 
               btn.setIcon(shuffle_on_music_img);
            }
      }
   }
   


   // 음악시작에서 정지 버튼으로 변경
   class ActionButtonHandler_sp implements ActionListener{
      
      @Override
      public void actionPerformed(ActionEvent e) {
//    	  index = getSongIndex("내목소리");//"포장마차"라는 부분을 유기적으로 바뀌게 해야함//노래 클릭 되었을 때 그 노래가 실행되게
//			System.out.println(media_AL.get(index));
//			playMusic1(media_AL.get(index));
			
         // TODO Auto-generated method stub
         JButton btn=(JButton) e.getSource();   
            if(btn.getIcon().equals(start_music_img)) {
               btn.setIcon(pause_music_img);
               start_music.setIcon(pause_music_img);
               pause_music.setIcon(pause_music_img);
            }
            else { 
               btn.setIcon(start_music_img);
               start_music.setIcon(start_music_img);
               pause_music.setIcon(start_music_img);
            }   
      }
   }
   
   // 한 번 재생에서 전체재생 버튼으로 변경
   class ActionButtonHandler_or implements ActionListener{
      
      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         JButton btn=(JButton) e.getSource();   
            if(btn.getIcon().equals(replay_music_img)) {
               btn.setIcon(once_play_img);
            }
            else { 
               btn.setIcon(replay_music_img);
            }
      }
   }
   
   // 음악 선택시 음악재생화면으로 전환
   class JListHandler2 implements ListSelectionListener{
      
      JLabel label;
      ArrayList<String> musiclist = new ArrayList<String>();
      
      JListHandler2(JLabel label){
         this.label=label;
      }
      
      @Override
      public void valueChanged(ListSelectionEvent e) {
         // TODO Auto-generated method stub
         
         boolean adjust = e.getValueIsAdjusting();
         if(!adjust) {
            JList list = (JList)e.getSource();
            String str = (String)list.getSelectedValue();
            int index_test = list.getSelectedIndex();
            label.setText(""+str);
            str = str.replaceAll(" ", "");
            play_main.setIcon(music_images[index_test]);
            musiclist.add(str);
            frame1.setVisible(false);
            frame2.setVisible(false);
            frame3.setVisible(true);
            
            System.out.println(index_test);
         }
         
         
         
      }   
   }
   
   // 프레임 전환
   class ActionButtonHandler1 implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         frame1.setVisible(false);
         frame2.setVisible(true);
         frame3.setVisible(false);
         frame4.setVisible(false);
      }
   }
   
   class ActionButtonHandler2 implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         frame1.setVisible(true);
         frame2.setVisible(false);
         frame3.setVisible(false);
         frame4.setVisible(false);
      }
   }
   
   class ActionButtonHandler3 implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         frame1.setVisible(false);
         frame2.setVisible(true);
         frame3.setVisible(false);
         frame4.setVisible(false);
         
      }
   }
   
   class ActionButtonHandler4 implements ActionListener{  

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         frame1.setVisible(false);
         frame2.setVisible(true);
         frame3.setVisible(false);
         frame4.setVisible(false);
      }
   }
   
   class ActionButtonHandler5 implements ActionListener{  //검색

         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            frame1.setVisible(false);
            frame2.setVisible(false);
            frame3.setVisible(false);
            frame4.setVisible(true);
         }
      }
   
   public static void main(String[] args) {
      new Media_test5();
   }
}
