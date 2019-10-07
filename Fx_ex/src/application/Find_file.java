package application;


import java.io.FileFilter;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
 
public class Find_file {
 
    public static ArrayList<String> jFileChooserUtil(){
        
        ArrayList <String> folderPath = new ArrayList<>();
        JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); // 디렉토리 설정
        chooser.setCurrentDirectory(new File("/")); // 현재 사용 디렉토리를 지정
        chooser.setAcceptAllFileFilterUsed(true);   // Fileter 모든 파일 적용 
        chooser.setDialogTitle("타이틀"); // 창의 제목
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // 파일 선택 모드
        chooser.setMultiSelectionEnabled(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Audio files", "mp3"); // filter 확장자 추가
        
        File file = new File("V:/tmp/");
    	
        chooser.setFileFilter(filter); // 파일 필터를 추가
       
        int returnVal = chooser.showOpenDialog(null); // 열기용 창 오픈
        
        if(returnVal == JFileChooser.APPROVE_OPTION) { // 열기를 클릭 
            //folderPath.add(chooser.getSelectedFiles());
        	File[] mFile = chooser.getSelectedFiles();
        	File[] file_for_directory = null;
        	boolean isDirectory = false;
        	for(int i=0; i<mFile.length; i++) {
        		if(mFile[i].isDirectory())
        		{
        			file_for_directory = mFile[i].listFiles();
        			isDirectory = true;
        		}
        	}
        	
        	if(isDirectory) {
        		for(int i=0; i<file_for_directory.length; i++) {
        			
        			if(file_for_directory[i].getPath().contains(".mp3")) {


        				folderPath.add(file_for_directory[i].getPath());
        			}
        		}
        	}else {
	        	for(int i=0; i<mFile.length; i++)
	        		folderPath.add(mFile[i].getPath());
        	}
        }else if(returnVal == JFileChooser.CANCEL_OPTION){ // 취소를 클릭
            System.out.println("cancel"); 
            folderPath.clear();
        }

        
        return folderPath;
        
    }
    public static void main(String[] args) {
    	ArrayList<String> a = new ArrayList<String>();
    	a=jFileChooserUtil();
    	for(int i=0;i<a.size();i++)
    	System.out.println(a.get(i));
		
	}
}
