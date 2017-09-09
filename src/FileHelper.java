import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class FileHelper {
	ArrayList<ArrayList<String>> ar = new ArrayList<ArrayList<String>>();
	
	public void FRead(String filename){
		try {
			File f = new File("C:\\Users\\daida\\Desktop\\workspace\\20170909\\downloadsample1.csv");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "Shift-JIS"));//エクセル:UTF-8, csv:Shift-JIS
			
			String line;
			// 1行ずつCSVファイルを読み込む
			int dnum =0;
			while ((line = br.readLine()) != null) {
				ArrayList<String> aaaa = new ArrayList<String>();
				String[] data = line.split(",", 0); // 行をカンマ区切りで配列に変換
				
				
				for (int i = 0;i<data.length;i++) {
					if( i==4 || i==6 || i==7 || i==12 || i==7){
						String elem = data[i];
						aaaa.add(elem);
					}
				}
				//System.out.println(aaaa);
				ar.add(aaaa);
			}
			//中身確認 debug
			for(int i =0;i<ar.size();i++){
				for(int j = 0;j<ar.get(i).size();j++){
					System.out.print(ar.get(i).get(j));
				}
				System.out.println();
			}
			br.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	

//  ファイルの書き込み
//PrintWriter p_writer    = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file_w3),"UTF-8")));
			
	
	public void combine(String path){
		//ディレクトリ指定
        File dir = new File(path);
        
        //フルパスで取得
        System.out.println("--ファイル一覧(フルパス)--");
        File[] files1 = dir.listFiles();
        for (int i = 0; i < files1.length; i++) {
           File file = files1[i];
           if (files1[i].isFile()){
               //ファイル名を表示
        			   
                System.out.println(file);
           }else if (files1[i].isDirectory()){
               //ディレクトリ名表示（※１）
               System.out.println("directory:::"+file);
            }
        }
	}

	
}
