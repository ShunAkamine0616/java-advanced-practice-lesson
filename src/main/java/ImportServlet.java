
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/importServlet")
public class ImportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * 下記のコメントを参考に、必要な処理を実装してください
         */

        // todo:入力値取得
    	String name = request.getParameter("data");
    	
        // 取り込んだ内容を保持するための変数(オブジェクト)
        Animal animal = null;
        
        // todo:
        // オブジェクトを作成し、上記の変数にセット
        // 選択したデータに応じて、作成するオブジェクトが異なる
   
        if(name.equals("cat")) {
        	animal = new Cat();
        } else if(name.equals("rabbit")) {
        	animal = new Rabbit();
        }
        
        // 結果画面に表示するメッセージ用の変数
        String result = "";

        // 取り込むファイル先用の変数
        Path file = Paths.get(animal.getFilePath());

        // 読み込んだファイル用の変数
        BufferedReader br = null;

        try {
            // ファイルを開く
            br = Files.newBufferedReader(file);

            // ファイル内の最初の1行を読み込み
            String text = br.readLine();

            // 行数保持用の変数
            // (値が0の場合、まだ読み込んでいない or 読み込み内容がないと判断)
            int count = 0;

            // ファイル内の中身を1行ずつ読み込み、
            // 読み込み内容が無くなるまで(textの値がnullになるまで)
            // 読み込みを繰り返す
            while (text != null) {
                // todo:行数加算
            	count++;
            	
                // todo:
                // 変数animalのフィールドに読み込んだ内容をセット
                // 現在の行数(count)に応じて、セットするフィールドが異なる
            	if(count == 1) {
            		animal.name= text;
            	} else if (count == 2) {
            		try {
            			animal.age = Integer.parseInt(text);
            		} catch (NumberFormatException e) {
            			e.printStackTrace();
            		}
            	}
                // ファイル内の次の1行を読み込み
                text = br.readLine();
            }

            // todo:
            // 変数animalのintroduceメソッドで表示する内容を取得し、
            // 変数resultにセット
            result = animal.introduce(); 
            
            // ファイルの読み込みに失敗した場合、例外が発生するので、
            // 「IOException」という型でcatchする
        } catch (IOException e) {
            // todo:
            // ファイルの読み込みに失敗した時のメッセージを
            // 変数resultにセット
        	result = "ファイルの読み込みに失敗しました。"
        			+ "対象のファイルの存在や文字コードを確認してください。";
        } finally {
            // 読み込んだファイルを閉じる
            // (finally句でこの処理を行うのは、
            // ファイルの読み込みが途中で失敗したとしても、
            // 問題なく処理が行えたとしても、
            // 開いたファイルを確実に閉じるため。
            // これをしないとファイルがずっと開きっぱなしに
            // なってしまう可能性がある)
            if (br != null) {
                br.close();
            }
        }

        // todo:結果画面に表示するメッセージをセット
        request.setAttribute("result", result);
        // 結果画面へ遷移
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
