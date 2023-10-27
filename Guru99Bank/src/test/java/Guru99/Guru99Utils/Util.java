package Guru99.Guru99Utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class Util {
	//SetUp
	public static final String FIREFOX_PATH = "C:\\Users\\geral\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\5a6l2h23.Guru99Bank";
	public static final int WAIT_TIME = 15;
	// rutas
	public static final String EVIDENCE_PATH = "..\\Guru99Bank\\evidence\\";
	//Login
	public static final String USER_NAME = "mngr533450";
	public static final String PWD = "arunAja";
	//Txt de comparaciones
	public static final String LOGIN_TITLE = "Guru99 Bank Home Page";
	public static final String HOME_TITLE = "Guru99 Bank Manager HomePage";
	public static final String ALERT_ERROR_LOGIN = "User or Password is not valid";
	public static final String ALERT_LOGOUT_LOGIN = "You Have Succesfully Logged Out!!";
	//Excel
	public static final String FILE_PATH = "..\\Guru99Bank\\data\\";
	public static final String FILE_NAME = "Datos_LoginGuru99.xlsx";
	public static final String SHEET_NAME = "Data_login";

	//Lectura de excel
	public static Object[][] leerExcel(String ruta, String nombreHoja) throws Exception {
		FileInputStream file = new FileInputStream(new File(ruta));

		XSSFWorkbook libroExcel = new XSSFWorkbook(file);
		XSSFSheet Hoja = libroExcel.getSheet(nombreHoja);

		System.out.println(nombreHoja);

		XSSFRow fila;
		int filas = Hoja.getPhysicalNumberOfRows();
		int columnas = Hoja.getRow(0).getPhysicalNumberOfCells();

		Object cellValue[][] = new Object[filas][columnas];

		for (int i = 0; i < filas; i++) {
			fila = Hoja.getRow(i);
			if (fila == null) {
				break;
			} else {
				for (int c = 0; c < columnas; c++) {
					DataFormatter dataFormatter = new DataFormatter();
					cellValue[i][c] = dataFormatter.formatCellValue(Hoja.getRow(i).getCell(c));
				}
			}
		}
		libroExcel.close();
		return cellValue;
	}
}
