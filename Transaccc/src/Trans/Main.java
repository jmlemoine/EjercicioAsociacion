package Trans;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.println("Escriba el nombre del archivo con las transacciones: ");
		String fn = input.nextLine();
		
		System.out.println("Digite el soporte minimo: ");
		int soporteMinimo = input.nextInt();
		
		System.out.println("Digite confianza minima: ");
		float confianzaMinima = input.nextFloat();
		input.close();
		
		int lineas=0, items=0;
		LinkedList<File> listFicheros = new LinkedList<>();
				
		for(int i=1; i<=5; i++) {
			listFicheros.add(new File(fn));
		}
		
		System.out.println("\nTransacciones");
		Archivo file = new Archivo();
		file.Lectura(fn);
		Scanner s = new Scanner(new File(fn));
		ArrayList<String> listS = new ArrayList<String>();
		ArrayList<Integer> listI = new ArrayList<Integer>();
		
		while(s.hasNextLine()) {
			listS.add(s.nextLine());
		}
		
		System.out.println("--------------------------------------------------");
		System.out.println("Transacciones: ");
		ArrayList<String> ls = listS;
		System.out.println(ls);
		
		int[] arreglocantidad = new int[8];
		for(int i=0; i<arreglocantidad.length; i++) {
			arreglocantidad[i]=0;
		}
		float[] confianzaminima = new float[8];
		for(int i=0; i<confianzaminima.length; i++) {
			confianzaminima[i]=0;
		}
		
		System.out.println("--------------------------------------------------");
		Archivo arc = new Archivo(listFicheros.get(0));
		lineas += arc.getLineas();
		System.out.println("En este archivo existen: "+lineas+" transacciones.");
		
		Pattern patrones = null;
		Matcher searcher = null;
		
		for(int i=0; i<ls.size(); i++) {
			for(int j=0; j<ls.get(i).length(); j++) {
				confianzaminima[i] = arreglocantidad[i] / lineas;
				
				if(ls.get(i).charAt(j) == 'A') {
					arreglocantidad[0]++;
					
				}
				else if (ls.get(i).charAt(j) == 'B') {
					arreglocantidad[1]++;
					
				}
				else if (ls.get(i).charAt(j) == 'C') {
					arreglocantidad[2]++;
					
				}
				else if (ls.get(i).charAt(j) == 'D') {
					arreglocantidad[3]++;
					
				}
				else if (ls.get(i).charAt(j) == 'E') {
					arreglocantidad[4]++;
					
				}
				else if (ls.get(i).charAt(j) == 'F') {
					arreglocantidad[5]++;
					
				}
			}
		}
		
		System.out.println("--------------------------------------------------");
		System.out.println("A: "+arreglocantidad[0]+"; B: "+arreglocantidad[1]+"; C: "+arreglocantidad[2]+"; D: "+arreglocantidad[3]+
				"; E: "+arreglocantidad[4]+"; F: "+arreglocantidad[5]);
		
		

		/* 1 */  String[] patternAB = {"A(?=B)", "A?B", "AB", "AB", "A?B"};
		/* 2 */  String[] patternAC = {"A(?=C)", "A?C", "AC","AC", "A?C"};
		/* 3 */  String[] patternAD = { "A?D", "A(?=D)", "A?D","AD", "AD", "A?D"}; 
		/* 4 */  String[] patternAE = { "A?E", "A(?=E)", "A?E","AE", "AE", "A?E"};
		/* 5 */  String patternAF = "A??F";
		/* 6 */  String[] patternBC = { "B(?=C)", "B?C", "BC","BC", "B?C"};
		/* 7 */  String[] patternBD = { "B(?=D)", "B?D", "BD", "BD","B?D"};
		/* 8 */  String[] patternBE = { "B(?=E)", "B?E", "B?E","BE", "BE"};
		/* 9 */  String patternBF = "B??F";
		/* 10 */ String patternCD = "C??D";
		/* 11 */ String[] patternCE = { "C(?=E)", "C?E", "C?E", "CE","CE"};
		/* 12 */ String[] patternCF = { "C(?=F)", "C?F", "C?F","CF", "CF"};
		/* 13 */ String[] patternDE = { "D(?=E)", "D(?=E)","DE", "DE", "D?E", "D?E"};
		/* 14 */ String[] patternDF = { "(?=F)", "(?=D)", "D?F","DF", "DF", "D?F"};
		/* 15 */ String[] patternEF = { "(?=E)", "(?=F)","EF", "E?F","EF", "E?F",};
		/* 16 */ String patternABC = "ABC";
		/* 17 */ String patternABD = "ABD";
		/* 18 */ String[] patternABE = {"ABE", "A?BE", "AB?E", "(?=A)", "(?=B)", "(?=E)"};
		/* 19 */ String[] patternABF = {"ABF", "A?BF", "AB?F", "(?=A)", "(?=B)", "(?=F)"};
		/* 20 */ String patternACD = "ACD";
		/* 21 */ String[] patternACE = {"ACE", "A?CE", "AC?E", "A??E", "(?=A)", "(?=C)", "(?=E)"};
		/* 22 */ String[] patternACF = {"ACF", "A?CF", "AC?F", "A??F", "(?=A)", "(?=C)", "(?=F)"};
		/* 22 */ String patternADE = "ADE";
		/* 23 */ String patternADF = "ADF";
		/* 24 */ String patternAEF = "AEF";
		/* 25 */ String patternBCD = "BCD";
		/* 26 */ String patternBCE = "BCE";
		/* 27 */ String patternBCF = "BCF";
		/* 28 */ String patternBDE = "BDE";
		/* 29 */ String patternBDF = "BDF";
		/* 30 */ String patternBEF = "BEF";
		/* 31 */ String patternCDE = "CDE";
		/* 32 */ String patternCDF = "CDF";
		/* 33 */ String patternCEF = "CEF";
		/* 34 */ String patternDEF = "DEF";
		/* 35 */ String patternABCD = "ABCD";
		/* 36 */ String patternABCE = "ABCE";
		/* 37 */ String patternABCF = "ABCF";
		/* 38 */ String patternABDE = "ABDE";
		/* 39 */ String patternABDF = "ABDF";
		/* 40 */ String patternABEF = "ABEF";
		/* 41 */ String patternACDE = "ACDE";
		/* 42 */ String patternACDF = "ACDF";
		/* 43 */ String patternACEF = "ACEF";
		/* 44 */ String patternADEF = "ADEF";
		/* 45 */ String patternBCDE = "BCDE";
		/* 46 */ String patternBCDF = "BCDF";
		/* 47 */ String patternBCEF = "BCEF";
		/* 48 */ String patternBDEF = "BDEF";
		/* 49 */ String patternCDEF = "CDEF";
		/* 50 */ String patternABCDE = "ABCDE";
		/* 51 */ String patternABCDF = "ABCDF";
		/* 52 */ String patternABCEF = "ABCEF";
		/* 53 */ String patternABDEF = "ABDEF";
		/* 54 */ String patternACDEF = "ACDEF";
		/* 55 */ String patternBCDEF = "BCDEF";
		
		
		int tamanoAB = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternAB[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoAB += 1;				
			}
		}
		
		int tamanoAC = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternAC[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoAC += 1;
				
			}
		}
		
		int tamanoAD = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternAD[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoAD += 1;
				
			}
		}
		
		int tamanoAE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternAE[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoAE += 1;
				
			}
		}
		
		int tamanoAF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternAF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoAF += 1;
				
			}
		}
		
		int tamanoBC = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBC[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBC += 1;
				
			}
		}
		
		int tamanoBD = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBD[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBD += 1;
				
			}
		}
		
		int tamanoBE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBE[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBE += 1;
				
			}
		}
		
		int tamanoBF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBF += 1;
				
			}
		}
		
		int tamanoCD = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternCD);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoCD += 1;
				
			}
		}
		
		int tamanoCE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternCE[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoCE += 1;
				
			}
		}
		
		int tamanoCF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternCF[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoCF += 1;
				
			}
		}
		
		int tamanoDE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternDE[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoDE += 1;
				
			}
		}
		
		int tamanoDF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternDF[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoDF += 1;
				
			}
		}
		
		int tamanoEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternEF[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoEF += 1;
				
			}
		}
		
		int tamanoABC = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABC);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABC += 1;
				
			}
		}
		
		int tamanoABD = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABD);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABD += 1;
				
			}
		}
		
		int tamanoABE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABE[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABE += 1;
				
			}
		}
		
		int tamanoABF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABF[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABF += 1;
				
			}
		}
		
		int tamanoACD = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternACD);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoACD += 1;
				
			}
		}

		int tamanoACE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternACE[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoACE += 1;
				
			}
		}
		
		int tamanoACF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternACF[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoACF += 1;
				
			}
		}
		
		int tamanoADE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternADE);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoADE += 1;
				
			}
		}
		
		int tamanoADF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternADF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoADF += 1;
				
			}
		}
		
		int tamanoAEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternAEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoAEF += 1;
				
			}
		}
		
		int tamanoBCD = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBCD);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBCD += 1;
				
			}
		}

		int tamanoBCE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBCE);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBCE += 1;
				
			}
		}
		
		int tamanoBCF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBCF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBCF += 1;
				
			}
		}
		
		int tamanoBDE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBDE);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBDE += 1;
				
			}
		}
		
		
		int tamanoBDF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBDF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBDF += 1;
				
			}
		}
		
		int tamanoBEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBEF += 1;
				
			}
		}
		
		int tamanoCDE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternCDE);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoCDE += 1;
				
			}
		}
		
		int tamanoCDF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternCDF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoCDF += 1;
				
			}
		}
		
		int tamanoCEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternCEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoCEF += 1;
				
			}
		}
		
		int tamanoDEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternDEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoDEF += 1;
				
			}
		}
		
		int tamanoABCD = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABCD);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABCD += 1;
				
			}
		}
		
		int tamanoABCE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABCE);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABCE += 1;
				
			}
		}
		
		int tamanoABCF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABCF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABCF += 1;
			
			}
		}
		
		int tamanoABDE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABDE);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABDE += 1;
				
			}
		}
		
		int tamanoABDF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABDF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABDF += 1;
				
			}
		}
		
		int tamanoABEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABEF += 1;
				
			}
		}
		
		int tamanoACDE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternACDE);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoACDE += 1;
				
			}
		}
		
		int tamanoACDF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternACDF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoACDF += 1;
				
			}
		}
		
		int tamanoACEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternACEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoACEF += 1;
				
			}
		}
		
		int tamanoADEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternADEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoADEF += 1;
				
			}
		}
		
		int tamanoBCDE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBCDE);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBCDE += 1;
				
			}
		}
		
		int tamanoBCDF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBCDF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBCDF += 1;
				
			}
		}
		
		int tamanoBCEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBCEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBCEF += 1;
				
			}
		}
		
		int tamanoBDEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBDEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBDEF += 1;
				
			}
		}
		
		int tamanoCDEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternCDEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoCDEF += 1;
				
			}
		}
		
		int tamanoABCDE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABCDE);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABCDE += 1;
				
			}
		}
		
		int tamanoABCDF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABCDF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABCDF += 1;
				
			}
		}
		
		int tamanoABCEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABCEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABCEF += 1;
				
			}
		}
		
		int tamanoABDEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABDEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABDEF += 1;
				
			}
		}
		
		int tamanoACDEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternACDEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoACDEF += 1;
				
			}
		}
		
		int tamanoBCDEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBCDEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBCDEF += 1;
			}
		}
		
		//CONJUNTOS
		
		//Conjunto conjuntoObject = new Conjunto();
		ArrayList<Conjunto> conjuntoArray = new ArrayList<Conjunto>();
		
		conjuntoArray.add(new Conjunto(tamanoAB, "AB"));
		conjuntoArray.add(new Conjunto(tamanoAC, "AC"));
		conjuntoArray.add(new Conjunto(tamanoAD, "AD"));
		conjuntoArray.add(new Conjunto(tamanoAE, "AE"));
		conjuntoArray.add(new Conjunto(tamanoAF, "AF"));
		conjuntoArray.add(new Conjunto(tamanoBC, "BC"));
		conjuntoArray.add(new Conjunto(tamanoBE, "BE"));
		conjuntoArray.add(new Conjunto(tamanoBF, "BF"));
		conjuntoArray.add(new Conjunto(tamanoCD, "CD"));
		conjuntoArray.add(new Conjunto(tamanoCE, "CE"));
		conjuntoArray.add(new Conjunto(tamanoCF, "CF"));
		conjuntoArray.add(new Conjunto(tamanoDE, "DE"));
		conjuntoArray.add(new Conjunto(tamanoDF, "DF"));
		conjuntoArray.add(new Conjunto(tamanoEF, "EF"));
		conjuntoArray.add(new Conjunto(tamanoABC, "ABC"));
		conjuntoArray.add(new Conjunto(tamanoABD, "ABD"));
		conjuntoArray.add(new Conjunto(tamanoABE, "ABE"));
		conjuntoArray.add(new Conjunto(tamanoABF, "ABF"));
		conjuntoArray.add(new Conjunto(tamanoACD, "ACD"));
		conjuntoArray.add(new Conjunto(tamanoACE, "ACE"));
		conjuntoArray.add(new Conjunto(tamanoACF, "ACF"));
		conjuntoArray.add(new Conjunto(tamanoADE, "ADE"));
		conjuntoArray.add(new Conjunto(tamanoADF, "ADF"));
		conjuntoArray.add(new Conjunto(tamanoAEF, "AEF"));
		conjuntoArray.add(new Conjunto(tamanoBCD, "BCD"));
		conjuntoArray.add(new Conjunto(tamanoBCE, "BCE"));
		conjuntoArray.add(new Conjunto(tamanoBCF, "BCF"));
		conjuntoArray.add(new Conjunto(tamanoBDE, "BDE"));
		conjuntoArray.add(new Conjunto(tamanoBDF, "BDF"));
		conjuntoArray.add(new Conjunto(tamanoBEF, "BEF"));
		conjuntoArray.add(new Conjunto(tamanoCDE, "CDE"));
		conjuntoArray.add(new Conjunto(tamanoCDF, "CDF"));
		conjuntoArray.add(new Conjunto(tamanoCEF, "CEF"));
		conjuntoArray.add(new Conjunto(tamanoDEF, "DEF"));
		conjuntoArray.add(new Conjunto(tamanoABCD, "ABCD"));
		conjuntoArray.add(new Conjunto(tamanoABCE, "ABCE"));
		conjuntoArray.add(new Conjunto(tamanoABCF, "ABCF"));
		conjuntoArray.add(new Conjunto(tamanoABDE, "ABDE"));
		conjuntoArray.add(new Conjunto(tamanoABDF, "ABDF"));
		conjuntoArray.add(new Conjunto(tamanoABEF, "ABEF"));
		conjuntoArray.add(new Conjunto(tamanoACDE, "ACDE"));
		conjuntoArray.add(new Conjunto(tamanoACDF, "ACDF"));
		conjuntoArray.add(new Conjunto(tamanoACEF, "ACEF"));
		conjuntoArray.add(new Conjunto(tamanoADEF, "ADEF"));
		conjuntoArray.add(new Conjunto(tamanoBCDE, "BCDE"));
		conjuntoArray.add(new Conjunto(tamanoBCDF, "BCDF"));
		conjuntoArray.add(new Conjunto(tamanoBCEF, "BCEF"));
		conjuntoArray.add(new Conjunto(tamanoBDEF, "BDEF"));
		conjuntoArray.add(new Conjunto(tamanoCDEF, "CDEF"));
		conjuntoArray.add(new Conjunto(tamanoABCDE, "ABCDE"));
		conjuntoArray.add(new Conjunto(tamanoABCDF, "ABCDF"));
		conjuntoArray.add(new Conjunto(tamanoABCDF, "ABCEF"));
		conjuntoArray.add(new Conjunto(tamanoABDEF, "ABDEF"));
		conjuntoArray.add(new Conjunto(tamanoACDEF, "ACDEF"));
		conjuntoArray.add(new Conjunto(tamanoBCDEF, "BCDEF"));
		
		Collections.sort(conjuntoArray, new Comparator<Conjunto>() {
			public int compare(Conjunto r1, Conjunto r2) {
				return  Integer.valueOf(r1.getTamanio()).compareTo(r2.getTamanio());
			}
		});
		
		//REGLAS
		
		//Regla cmObject = new Regla();
		ArrayList<Regla> cmArray = new ArrayList<Regla>();
				
		float confianzaminimaAB = ((float) tamanoAB / (float) arreglocantidad[0]);
		cmArray.add(new Regla(confianzaminimaAB, "A->B"));
		
		float confianzaminimaAC = ((float) tamanoAC / (float) arreglocantidad[0]);
		cmArray.add(new Regla(confianzaminimaAC, "A->C"));
		
		float confianzaminimaAD = ((float) tamanoAD / (float) arreglocantidad[0]);
		cmArray.add(new Regla(confianzaminimaAD, "A->D"));

		float confianzaminimaAE = ((float) tamanoAE / (float) arreglocantidad[0]);
		cmArray.add(new Regla(confianzaminimaAE, "A->E"));
		
		float confianzaminimaAF = ((float) tamanoAF / (float) arreglocantidad[0]);
		cmArray.add(new Regla(confianzaminimaAF, "A->F"));
		
		float confianzaminimaBA = ((float) tamanoAB / (float) arreglocantidad[1]);
		cmArray.add(new Regla(confianzaminimaBA, "B->A"));
		
		float confianzaminimaBC = ((float) tamanoBC / (float) arreglocantidad[1]);
		cmArray.add(new Regla(confianzaminimaBC, "B->C"));
		
		float confianzaminimaBD = ((float) tamanoBD / (float) arreglocantidad[1]);
		cmArray.add(new Regla(confianzaminimaBD, "B->D"));

		float confianzaminimaBE = ((float) tamanoBE / (float) arreglocantidad[1]);
		cmArray.add(new Regla(confianzaminimaBE, "B->E"));
		
		float confianzaminimaBF = ((float) tamanoBF / (float) arreglocantidad[1]);
		cmArray.add(new Regla(confianzaminimaBF, "B->F"));
		
		float confianzaminimaCA = ((float) tamanoAC / (float) arreglocantidad[2]);
		cmArray.add(new Regla(confianzaminimaCA, "C->A"));
		
		float confianzaminimaCB = ((float) tamanoBC / (float) arreglocantidad[2]);
		cmArray.add(new Regla(confianzaminimaCB, "C->B"));
	
		float confianzaminimaCD = ((float) tamanoCD / (float) arreglocantidad[2]);
		cmArray.add(new Regla(confianzaminimaCD, "C->D"));

		float confianzaminimaCE = ((float) tamanoCE / (float) arreglocantidad[2]);
		cmArray.add(new Regla(confianzaminimaCE, "C->E"));
		
		float confianzaminimaCF = ((float) tamanoCF / (float) arreglocantidad[2]);
		cmArray.add(new Regla(confianzaminimaCF, "C->F"));
		
		float confianzaminimaDA = ((float) tamanoAD / (float) arreglocantidad[3]);
		cmArray.add(new Regla(confianzaminimaDA, "D->A"));
		
		float confianzaminimaDB = ((float) tamanoBD / (float) arreglocantidad[3]);
		cmArray.add(new Regla(confianzaminimaDB, "D->B"));
		
		float confianzaminimaDC = ((float) tamanoCD / (float) arreglocantidad[3]);
		cmArray.add(new Regla(confianzaminimaDC, "D->C"));

		float confianzaminimaDE = ((float) tamanoDE / (float) arreglocantidad[3]);
		cmArray.add(new Regla(confianzaminimaDE, "D->E"));
		
		float confianzaminimaDF = ((float) tamanoDF / (float) arreglocantidad[3]);
		cmArray.add(new Regla(confianzaminimaDF, "D->F"));
		
		float confianzaminimaEA = ((float) tamanoAE / (float) arreglocantidad[4]);
		cmArray.add(new Regla(confianzaminimaEA, "E->A"));
		
		float confianzaminimaEB = ((float) tamanoBE / (float) arreglocantidad[4]);
		cmArray.add(new Regla(confianzaminimaEB, "E->B"));
		
		float confianzaminimaEC = ((float) tamanoCE / (float) arreglocantidad[4]);
		cmArray.add(new Regla(confianzaminimaEC, "E->C"));

		float confianzaminimaED = ((float) tamanoDE / (float) arreglocantidad[4]);
		cmArray.add(new Regla(confianzaminimaED, "E->D"));
		
		float confianzaminimaEF = ((float) tamanoEF / (float) arreglocantidad[4]);
		cmArray.add(new Regla(confianzaminimaEF, "E->F"));
		
		float confianzaminimaFA = ((float) tamanoAF / (float) arreglocantidad[5]);
		cmArray.add(new Regla(confianzaminimaFA, "F->A"));
		
		float confianzaminimaFB = ((float) tamanoBF / (float) arreglocantidad[5]);
		cmArray.add(new Regla(confianzaminimaFB, "F->B"));
		
		float confianzaminimaFC = ((float) tamanoCF / (float) arreglocantidad[5]);
		cmArray.add(new Regla(confianzaminimaFC, "F->C"));

		float confianzaminimaFD = ((float) tamanoDF / (float) arreglocantidad[5]);
		cmArray.add(new Regla(confianzaminimaFD, "F->D"));
		
		float confianzaminimaFE = ((float) tamanoEF / (float) arreglocantidad[5]);
		cmArray.add(new Regla(confianzaminimaFE, "D->F"));
		
		float confianzaminimaBCA = ((float) tamanoABC / (float) tamanoBC);
		cmArray.add(new Regla(confianzaminimaBCA, "BC->A"));
		
		float confianzaminimaBDA = ((float) tamanoABD / (float) tamanoBD);
		cmArray.add(new Regla(confianzaminimaBDA, "BD->A"));
		
		float confianzaminimaBEA = ((float) tamanoABE / (float) tamanoBE);
		cmArray.add(new Regla(confianzaminimaBEA, "BE->A"));
		
		float confianzaminimaBFA = ((float) tamanoABF / (float) tamanoBF);
		cmArray.add(new Regla(confianzaminimaBFA, "BF->A"));
		
		float confianzaminimaCDA = ((float) tamanoACD / (float) tamanoCD);
		cmArray.add(new Regla(confianzaminimaCDA, "CD->A"));
		
		float confianzaminimaCEA = ((float) tamanoACE / (float) tamanoCE);
		cmArray.add(new Regla(confianzaminimaCEA, "CE->A"));
		
		float confianzaminimaCFA = ((float) tamanoACF / (float) tamanoCF);
		cmArray.add(new Regla(confianzaminimaCFA, "CF->A"));
		
		float confianzaminimaDEA = ((float) tamanoADE / (float) tamanoDE);
		cmArray.add(new Regla(confianzaminimaDEA, "DE->A"));
		
		float confianzaminimaDFA = ((float) tamanoADF / (float) tamanoDF);
		cmArray.add(new Regla(confianzaminimaDFA, "DF->A"));
		
		float confianzaminimaEFA = ((float) tamanoAEF / (float) tamanoEF);
		cmArray.add(new Regla(confianzaminimaEFA, "EF->A"));
		
		float confianzaminimaACB = ((float) tamanoABC / (float) tamanoAC);
		cmArray.add(new Regla(confianzaminimaACB, "AC->B"));
		
		float confianzaminimaADB = ((float) tamanoABD / (float) tamanoAD);
		cmArray.add(new Regla(confianzaminimaADB, "AD->B"));
		
		float confianzaminimaAEB = ((float) tamanoABE / (float) tamanoAF);
		cmArray.add(new Regla(confianzaminimaAEB, "AE->B"));
		
		float confianzaminimaAFB = ((float) tamanoABF / (float) tamanoAF);
		cmArray.add(new Regla(confianzaminimaAFB, "AF->B"));
		
		float confianzaminimaCDB = ((float) tamanoBCD / (float) tamanoCD);
		cmArray.add(new Regla(confianzaminimaCDB, "CD->B"));
		
		float confianzaminimaCEB = ((float) tamanoBCE / (float) tamanoCE);
		cmArray.add(new Regla(confianzaminimaCEB, "CE->B"));
		
		float confianzaminimaCFB = ((float) tamanoBCF / (float) tamanoCF);
		cmArray.add(new Regla(confianzaminimaCFB, "CF->B"));
		
		float confianzaminimaDEB = ((float) tamanoBDE / (float) tamanoDE);
		cmArray.add(new Regla(confianzaminimaDEB, "DE->B"));
		
		float confianzaminimaDFB = ((float) tamanoBDF / (float) tamanoDF);
		cmArray.add(new Regla(confianzaminimaDFB, "DF->B"));
		
		float confianzaminimaEFB = ((float) tamanoBEF / (float) tamanoEF);
		cmArray.add(new Regla(confianzaminimaEFB, "EF->B"));
		
		float confianzaminimaABC = ((float) tamanoABC / (float) tamanoAB);
		cmArray.add(new Regla(confianzaminimaABC, "AB->C"));
		
		float confianzaminimaADC = ((float) tamanoACD / (float) tamanoAD);
		cmArray.add(new Regla(confianzaminimaADC, "AD->C"));
		
		float confianzaminimaAEC = ((float) tamanoACE / (float) tamanoAE);
		cmArray.add(new Regla(confianzaminimaAEC, "AE->C"));
		
		float confianzaminimaAFC = ((float) tamanoACF / (float) tamanoAF);
		cmArray.add(new Regla(confianzaminimaAFC, "AF->C"));
		
		float confianzaminimaBDC = ((float) tamanoBCD / (float) tamanoBD);
		cmArray.add(new Regla(confianzaminimaBDC, "BD->C"));
		
		float confianzaminimaBEC = ((float) tamanoBCE / (float) tamanoBE);
		cmArray.add(new Regla(confianzaminimaBEC, "BE->C"));
		
		float confianzaminimaBFC = ((float) tamanoBCF / (float) tamanoBF);
		cmArray.add(new Regla(confianzaminimaBFC, "BF->C"));
		
		float confianzaminimaDEC = ((float) tamanoCDE / (float) tamanoDE);
		cmArray.add(new Regla(confianzaminimaDEC, "DE->C"));
		
		float confianzaminimaDFC = ((float) tamanoCDF / (float) tamanoDF);
		cmArray.add(new Regla(confianzaminimaDFC, "DF->C"));
		
		float confianzaminimaEFC = ((float) tamanoCEF / (float) tamanoEF);
		cmArray.add(new Regla(confianzaminimaEFC, "EF->C"));
		
		float confianzaminimaABD = ((float) tamanoABD / (float) tamanoAB);
		cmArray.add(new Regla(confianzaminimaABD, "AB->D"));
		
		float confianzaminimaACD = ((float) tamanoACD / (float) tamanoAC);
		cmArray.add(new Regla(confianzaminimaACD, "AC->D"));
		
		float confianzaminimaAED = ((float) tamanoADE / (float) tamanoAE);
		cmArray.add(new Regla(confianzaminimaAED, "AE->D"));
		
		float confianzaminimaAFD = ((float) tamanoADF / (float) tamanoAF);
		cmArray.add(new Regla(confianzaminimaAFD, "AF->D"));
		
		float confianzaminimaBCD = ((float) tamanoBCD / (float) tamanoBC);
		cmArray.add(new Regla(confianzaminimaBCD, "BC->D"));
		
		float confianzaminimaBED = ((float) tamanoBDE / (float) tamanoBE);
		cmArray.add(new Regla(confianzaminimaBED, "BE->D"));
		
		float confianzaminimaBFD = ((float) tamanoBDF / (float) tamanoBF);
		cmArray.add(new Regla(confianzaminimaBFD, "BF->D"));
		
		float confianzaminimaCED = ((float) tamanoCDE / (float) tamanoCE);
		cmArray.add(new Regla(confianzaminimaCED, "CE->D"));
		
		float confianzaminimaCFD = ((float) tamanoCDF / (float) tamanoCF);
		cmArray.add(new Regla(confianzaminimaCFD, "CF->D"));
		
		float confianzaminimaEFD = ((float) tamanoDEF / (float) tamanoEF);
		cmArray.add(new Regla(confianzaminimaEFD, "EF->D"));
		
		float confianzaminimaABE = ((float) tamanoABE / (float) tamanoAB);
		cmArray.add(new Regla(confianzaminimaABE, "AB->E"));
		
		float confianzaminimaACE = ((float) tamanoACE / (float) tamanoAC);
		cmArray.add(new Regla(confianzaminimaACE, "AC->E"));
		
		float confianzaminimaADE = ((float) tamanoADE / (float) tamanoAD);
		cmArray.add(new Regla(confianzaminimaADE, "AE->D"));
		
		float confianzaminimaAFE = ((float) tamanoADE / (float) tamanoAF);
		cmArray.add(new Regla(confianzaminimaAFE, "AF->E"));
		
		float confianzaminimaBCE = ((float) tamanoBCE / (float) tamanoBC);
		cmArray.add(new Regla(confianzaminimaBCE, "BC->E"));
		
		float confianzaminimaBDE = ((float) tamanoBDE / (float) tamanoBD);
		cmArray.add(new Regla(confianzaminimaBDE, "BD->E"));
		
		float confianzaminimaBFE = ((float) tamanoBEF / (float) tamanoBF);
		cmArray.add(new Regla(confianzaminimaBFE, "BF->E"));
		
		float confianzaminimaCDE = ((float) tamanoCDE / (float) tamanoCD);
		cmArray.add(new Regla(confianzaminimaCDE, "CD->E"));
		
		float confianzaminimaCFE = ((float) tamanoCEF / (float) tamanoCF);
		cmArray.add(new Regla(confianzaminimaCFE, "CF->E"));
		
		float confianzaminimaDFE = ((float) tamanoDEF / (float) tamanoDF);
		cmArray.add(new Regla(confianzaminimaDFE, "DF->E"));
		
		float confianzaminimaFAB = ((float) tamanoABF / (float) tamanoAB);
		cmArray.add(new Regla(confianzaminimaFAB, "F->AB"));
		
		float confianzaminimaFAC = ((float) tamanoACF / (float) tamanoAC);
		cmArray.add(new Regla(confianzaminimaFAC, "F->AC"));
		
		float confianzaminimaFAD = ((float) tamanoADF / (float) tamanoAD);
		cmArray.add(new Regla(confianzaminimaFAD, "F->AD"));
		
		float confianzaminimaFAE = ((float) tamanoAEF / (float) tamanoAE);
		cmArray.add(new Regla(confianzaminimaFAE, "F->AE"));
		
		float confianzaminimaFBC = ((float) tamanoBCF / (float) tamanoBC);
		cmArray.add(new Regla(confianzaminimaFBC, "F->BC"));
		
		float confianzaminimaFBD = ((float) tamanoBDF / (float) tamanoBD);
		cmArray.add(new Regla(confianzaminimaFBD, "F->BD"));
		
		float confianzaminimaFBE = ((float) tamanoBEF / (float) tamanoBE);
		cmArray.add(new Regla(confianzaminimaFBE, "F->BE"));
		
		float confianzaminimaFCD = ((float) tamanoCDF / (float) tamanoCD);
		cmArray.add(new Regla(confianzaminimaFCD, "F->CD"));
		
		float confianzaminimaFCE = ((float) tamanoCEF / (float) tamanoCE);
		cmArray.add(new Regla(confianzaminimaFCE, "F->CE"));
		
		float confianzaminimaFDE = ((float) tamanoDEF / (float) tamanoDE);
		cmArray.add(new Regla(confianzaminimaFDE, "F->DE"));
		
		ArrayList<Regla> cmArrayResult = cmArray;
		Collections.sort(cmArrayResult, new Comparator<Regla>() {
			public int compare(Regla r1, Regla r2) {
				return  Float.valueOf(r1.getConfianzaMinima()).compareTo(r2.getConfianzaMinima());
			}
		});
		
		System.out.println("\n\n -----------------RESULTADOS-------------------");
		System.out.println("Soporte minimo: " + soporteMinimo);
		System.out.println("Confianza minima: " + confianzaMinima);
		
		System.out.println("\n\n  -- Conjuntos -- ");
		
		for(int i = conjuntoArray.size() - 1; i >= 0; i--) {
			if(conjuntoArray.get(i).getTamanio() >= soporteMinimo ) {
				System.out.println("Existen " + conjuntoArray.get(i).getTamanio() + " de: " + conjuntoArray.get(i).getConjunto());
			}
		}
		
		System.out.println("\n\n  -- Reglas -- ");
		
		for(int i = cmArrayResult.size() - 1; i >= 0; i--) {
			if(cmArrayResult.get(i).getConfianzaMinima() >= confianzaMinima && cmArrayResult.get(i).getConfianzaMinima() <= 1 &&
					!( cmArrayResult.get(i).getConfianzaMinima() != cmArrayResult.get(i).getConfianzaMinima())) {
				
						System.out.println("La confianza minima de " + cmArrayResult.get(i).getRegla() + " es: " + cmArrayResult.get(i).getConfianzaMinima());
			}
		}
		
	}

}
