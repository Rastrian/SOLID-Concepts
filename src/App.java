import main_service.MainService;

public class App {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
            System.out.println("→ Iniciando sistema.");
            MainService rc = new MainService();
            Thread t = new Thread(rc);
            t.start();
            t.join();
            System.out.println("→ Sistema finalizado.");
        } catch (Exception e){
            e.printStackTrace();
        }
	}

}
