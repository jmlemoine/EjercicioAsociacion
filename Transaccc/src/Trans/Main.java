package Trans;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner filename = new Scanner(System.in);
		System.out.println("Escriba el nombre del archivo con las transacciones: ");
		String fn = filename.nextLine();
		int lineas=0, items=0;
		LinkedList<File> listFicheros = new LinkedList<>();
				
		for(int i=1; i<=5; i++) {
			listFicheros.add(new File(fn));
		}
		
		System.out.println("\nTransacciones");
		Archivo file = new Archivo();
		file.Lectura(fn);
		Scanner s = new Scanner(new File("a.txt"));
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
				confianzaminima[i] = arreglocantidad[i]/ lineas;
				
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
		
		
		String[] patternAB = {"A(?=B)", "A?B", "AB", "AB", "A?B"};
		
		int tamanoAB = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternAB[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoAB += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoAB+" AB");
		
		String[] patternAC = {"A(?=C)", "A?C", "AC", "AC", "A?C"};

		int tamanoAC = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternAC[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoAC += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoAC+" AC");
		
		String[] patternAD = {"A?D", "A(?=D)", "A?D", "AD", "AD", "A?D"}; 

		int tamanoAD = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternAD[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoAD += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoAD+" AD");
		
		String[] patternAE = {"A?E", "A(?=E)", "A?E", "AE", "AE", "A?E"};

		int tamanoAE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternAE[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoAE += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoAE+" AE");
		
		String patternAF = "A??F";

		int tamanoAF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternAF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoAF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoAF+" AF");
		
		String[] patternBC = {"B(?=C)", "B?C", "BC", "BC", "B?C"};

		int tamanoBC = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBC[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBC += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoBC+" BC");
		
		String[] patternBD = {"B(?=D)", "B?D", "BD", "BD", "B?D"};

		int tamanoBD = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBD[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBD += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoBD+" BD");
		
		String[] patternBE = {"B(?=E)", "B?E", "B?E", "BE", "BE"};

		int tamanoBE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBE[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBE += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoBE+" BE");
		
		String patternBF = "B??F";

		int tamanoBF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoBF+" BF");
		
		String patternCD = "C??D";

		int tamanoCD = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternCD);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoCD += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoCD+" CD");
		
		String patternCE[] = {"C(?=E)", "C?E", "C?E", "CE", "CE"};

		int tamanoCE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternCE[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoCE += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoCE+" CE");
		
		String patternCF[] = {"C(?=F)", "C?F", "C?F", "CF", "CF"};

		int tamanoCF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternCF[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoCF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoCF+" CF");
		
		String[] patternDE = {"D(?=E)", "D(?=E)", "DE", "DE", "D?E", "D?E"};

		int tamanoDE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternDE[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoDE += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoDE+" DE");
		
		String[] patternDF = {"(?=F)", "(?=D)", "D?F", "DF", "DF", "D?F"};

		int tamanoDF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternDF[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoDF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoDF+" DF");
		
		String[] patternEF = {"(?=E)", "(?=F)", "EF", "E?F", "EF", "E?F",};

		int tamanoEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternEF[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoEF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoEF+" EF");
		
		String patternABC = "ABC";

		int tamanoABC = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABC);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABC += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoABC+" ABC");
		
		String patternABD = "ABD";

		int tamanoABD = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABD);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABD += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoABD+" ABD");
		
		String[] patternABE = {"ABE", "A?BE", "AB?E", "(?=A)", "(?=B)", "(?=E)"};
		int tamanoABE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABE[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABE += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoABE+" ABE");
		
		String[] patternABF = {"ABF", "A?BF", "AB?F", "(?=A)", "(?=B)", "(?=F)"};
		int tamanoABF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABF[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoABF+" ABF");

		String patternACD = "ACD";
		int tamanoACD = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternACD);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoACD += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoACD+" ACD");
		
		String[] patternACE = {"ACE", "A?CE", "AC?E", "A??E", "(?=A)", "(?=C)", "(?=E)"};
		int tamanoACE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternACE[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoACE += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoACE+" ACE");
		
		String[] patternACF = {"ACF", "A?CF", "AC?F", "A??F", "(?=A)", "(?=C)", "(?=F)"};
		int tamanoACF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternACF[i]);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoACF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoACF+" ACF");
		
		String patternADE = "ADE";
		int tamanoADE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternADE);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoADE += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoADE+" ADE");
		
		String patternADF = "ADF";
		int tamanoADF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternADF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoADF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoADF+" ADF");
		
		String patternAEF = "AEF";
		int tamanoAEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternAEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoAEF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoAEF+" AEF");
		
		String patternBCD = "BCD";
		int tamanoBCD = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBCD);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBCD += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoBCD+" BCD");
		
		String patternBCE = "BCE";
		int tamanoBCE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBCE);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBCE += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoBCE+" BCE");
		
		String patternBCF = "BCF";
		int tamanoBCF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBCF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBCF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoBCF+" BCF");
		
		String patternBDE = "BDE";
		int tamanoBDE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBDE);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBDE += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoBDE+" BDE");
		
		String patternBDF = "BDF";
		int tamanoBDF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBDF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBDF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoBDF+" BDF");
		
		String patternBEF = "BEF";
		int tamanoBEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBEF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoBEF+" BEF");
		
		String patternCDE = "CDE";
		int tamanoCDE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternCDE);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoCDE += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoCDE+" CDE");
		
		String patternCDF = "CDF";
		int tamanoCDF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternCDF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoCDF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoCDF+" CDF");
		
		String patternCEF = "CEF";
		int tamanoCEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternCEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoCEF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoCEF+" CEF");

		String patternDEF = "DEF";
		int tamanoDEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternDEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoDEF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoDEF+" DEF");
		
		String patternABCD = "ABCD";
		int tamanoABCD = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABCD);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABCD += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoABCD+" ABCD");
		
		String patternABCE = "ABCE";
		int tamanoABCE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABCE);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABCE += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoABCE+" ABCE");
		
		String patternABCF = "ABCF";
		int tamanoABCF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABCF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABCF += 1;
			
			}
		}
		System.out.println("Existen: "+tamanoABCF+" ABCF");
		
		String patternABDE = "ABDE";
		int tamanoABDE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABDE);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABDE += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoABDE+" ABDE");
		
		String patternABDF = "ABDF";
		int tamanoABDF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABDF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABDF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoABDF+" ABDF");
		
		String patternABEF = "ABEF";
		int tamanoABEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABEF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoABEF+" ABEF");
		
		String patternACDE = "ACDE";
		int tamanoACDE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternACDE);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoACDE += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoACDE+" ACDE");
		
		String patternACDF = "ACDF";
		int tamanoACDF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternACDF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoACDF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoACDF+" ACDF");
		
		String patternACEF = "ACEF";
		int tamanoACEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternACEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoACEF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoACEF+" ACEF");
		
		String patternADEF = "ADEF";
		int tamanoADEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternADEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoADEF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoADEF+" ADEF");
		
		String patternBCDE = "BCDE";
		int tamanoBCDE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBCDE);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBCDE += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoBCDE+" BCDE");
		
		String patternBCDF = "BCDF";
		int tamanoBCDF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBCDF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBCDF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoBCDF+" BCDF");
		
		String patternBCEF = "BCEF";
		int tamanoBCEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBCEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBCEF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoBCEF+" BCEF");
		
		String patternBDEF = "BDEF";
		int tamanoBDEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBDEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBDEF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoBDEF+" BDEF");
		
		String patternCDEF = "CDEF";
		int tamanoCDEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternCDEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoCDEF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoCDEF+" CDEF");
		
		String patternABCDE = "ABCDE";
		int tamanoABCDE = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABCDE);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABCDE += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoABCDE+" ABCDE");
		
		String patternABCDF = "ABCDF";
		int tamanoABCDF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABCDF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABCDF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoABCDF+" ABCDF");
		
		String patternABCEF = "ABCEF";
		int tamanoABCEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABCEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABCEF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoABCDF+" ABCEF");
		
		String patternABDEF = "ABDEF";
		int tamanoABDEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternABDEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoABDEF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoABDEF+" ABDEF");
		
		String patternACDEF = "ACDEF";
		int tamanoACDEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternACDEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoACDEF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoACDEF+" ACDEF");
		
		String patternBCDEF = "BCDEF";
		int tamanoBCDEF = 0;
		
		for(int i = 0; i < ls.size(); i++) {
			patrones = Pattern.compile(patternBCDEF);
			searcher = patrones.matcher(ls.get(i));
			if(searcher.find()) {
				tamanoBCDEF += 1;
				
			}
		}
		System.out.println("Existen: "+tamanoBCDEF+" BCDEF");
		
		float confianzaminimaAB = ((float) tamanoAB / (float) arreglocantidad[0]);
		System.out.println("\nLa minima confianza de A->B es:" + confianzaminimaAB);
		
		float confianzaminimaAC = ((float) tamanoAC / (float) arreglocantidad[0]);
		System.out.println("La minima confianza de A->C es:" + confianzaminimaAC);
		
		float confianzaminimaAD = ((float) tamanoAD / (float) arreglocantidad[0]);
		System.out.println("La minima confianza A->D es:" + confianzaminimaAD);

		float confianzaminimaAE = ((float) tamanoAE / (float) arreglocantidad[0]);
		System.out.println("La minima confianza de A->E es:" + confianzaminimaAE);
		
		float confianzaminimaAF = ((float) tamanoAF / (float) arreglocantidad[0]);
		System.out.println("La minima confianza de A->F es:" + confianzaminimaAF);
		
		
		float confianzaminimaBA = ((float) tamanoAB / (float) arreglocantidad[1]);
		System.out.println("La minima confianza B->A es:" + confianzaminimaBA);
		
		float confianzaminimaBC = ((float) tamanoBC / (float) arreglocantidad[1]);
		System.out.println("La minima confianza de B->C es:" + confianzaminimaBC);
		
		float confianzaminimaBD = ((float) tamanoBD / (float) arreglocantidad[1]);
		System.out.println("La minima confianza de B->D es:" + confianzaminimaBD);

		float confianzaminimaBE = ((float) tamanoBE / (float) arreglocantidad[1]);
		System.out.println("La minima confianza de B->E es:" + confianzaminimaBE);
		
		float confianzaminimaBF = ((float) tamanoBF / (float) arreglocantidad[1]);
		System.out.println("La minima confianza de B->F es:" + confianzaminimaBF);
		
		float confianzaminimaCA = ((float) tamanoAC / (float) arreglocantidad[2]);
		System.out.println("La minima confianza de C->A es:" + confianzaminimaCA);
		
		float confianzaminimaCB = ((float) tamanoBC / (float) arreglocantidad[2]);
		System.out.println("La minima confianza de C->B es:" + confianzaminimaCB);
	
		float confianzaminimaCD = ((float) tamanoCD / (float) arreglocantidad[2]);
		System.out.println("La minima confianza de C->D es:" + confianzaminimaCD);

		float confianzaminimaCE = ((float) tamanoCE / (float) arreglocantidad[2]);
		System.out.println("La minima confianza de C->E es:" + confianzaminimaCE);
		
		float confianzaminimaCF = ((float) tamanoCF / (float) arreglocantidad[2]);
		System.out.println("La minima confianza de C->F es:" + confianzaminimaCF);
		
		float confianzaminimaDA = ((float) tamanoAD / (float) arreglocantidad[3]);
		System.out.println("La minima confianza de D->A es:" + confianzaminimaDA);
		
		float confianzaminimaDB = ((float) tamanoBD / (float) arreglocantidad[3]);
		System.out.println("La minima confianza de D->B es:" + confianzaminimaDB);
		
		float confianzaminimaDC = ((float) tamanoCD / (float) arreglocantidad[3]);
		System.out.println("La minima confianza de D->C es:" + confianzaminimaDC);

		float confianzaminimaDE = ((float) tamanoDE / (float) arreglocantidad[3]);
		System.out.println("La minima confianza de D->E es:" + confianzaminimaDE);
		
		float confianzaminimaDF = ((float) tamanoDF / (float) arreglocantidad[3]);
		System.out.println("La minima confianza de D->F es:" + confianzaminimaDF);
		
		float confianzaminimaEA = ((float) tamanoAE / (float) arreglocantidad[4]);
		System.out.println("La minima confianza de E->A es:" + confianzaminimaEA);
		
		float confianzaminimaEB = ((float) tamanoBE / (float) arreglocantidad[4]);
		System.out.println("La minima confianza de E->B es:" + confianzaminimaEB);
		
		float confianzaminimaEC = ((float) tamanoCE / (float) arreglocantidad[4]);
		System.out.println("La minima confianza de E->C es:" + confianzaminimaEC);

		float confianzaminimaED = ((float) tamanoDE / (float) arreglocantidad[4]);
		System.out.println("La minima confianza de E->D es:" + confianzaminimaED);
		
		float confianzaminimaEF = ((float) tamanoEF / (float) arreglocantidad[4]);
		System.out.println("La minima confianza de E->F es:" + confianzaminimaEF);
		
		float confianzaminimaFA = ((float) tamanoAF / (float) arreglocantidad[5]);
		System.out.println("La minima confianza de F->A es:" + confianzaminimaFA);
		
		float confianzaminimaFB = ((float) tamanoBF / (float) arreglocantidad[5]);
		System.out.println("La minima confianza de F->B es:" + confianzaminimaFB);
		
		float confianzaminimaFC = ((float) tamanoCF / (float) arreglocantidad[5]);
		System.out.println("La minima confianza de F->C es:" + confianzaminimaFC);

		float confianzaminimaFD = ((float) tamanoDF / (float) arreglocantidad[5]);
		System.out.println("La minima confianza de F->D es:" + confianzaminimaFD);
		
		float confianzaminimaFE = ((float) tamanoEF / (float) arreglocantidad[5]);
		System.out.println("La minima confianza de D->F es:" + confianzaminimaFE);
		
		float confianzaminimaBCA = ((float) tamanoABC / (float) tamanoBC);
		System.out.println("La minima confianza de BC->A es:" + confianzaminimaBCA);
		
		float confianzaminimaBDA = ((float) tamanoABD / (float) tamanoBD);
		System.out.println("La minima confianza de BD->A es:" + confianzaminimaBDA);
		
		float confianzaminimaBEA = ((float) tamanoABE / (float) tamanoBE);
		System.out.println("La minima confianza de BE->A es:" + confianzaminimaBEA);
		
		float confianzaminimaBFA = ((float) tamanoABF / (float) tamanoBF);
		System.out.println("La minima confianza de BF->A es:" + confianzaminimaBFA);
		
		float confianzaminimaCDA = ((float) tamanoACD / (float) tamanoCD);
		System.out.println("La minima confianza de CD->A es:" + confianzaminimaBCA);
		
		float confianzaminimaCEA = ((float) tamanoACE / (float) tamanoCE);
		System.out.println("La minima confianza de CE->A es:" + confianzaminimaCEA);
		
		float confianzaminimaCFA = ((float) tamanoACF / (float) tamanoCF);
		System.out.println("La minima confianza de CF->A es:" + confianzaminimaCFA);
		
		float confianzaminimaDEA = ((float) tamanoADE / (float) tamanoDE);
		System.out.println("La minima confianza de DE->A es:" + confianzaminimaDEA);
		
		float confianzaminimaDFA = ((float) tamanoADF / (float) tamanoDF);
		System.out.println("La minima confianza de DF->A es:" + confianzaminimaDFA);
		
		float confianzaminimaEFA = ((float) tamanoAEF / (float) tamanoEF);
		System.out.println("La minima confianza de EF->A es:" + confianzaminimaEFA);
		
		float confianzaminimaACB = ((float) tamanoABC / (float) tamanoAC);
		System.out.println("La minima confianza de AC->B es:" + confianzaminimaACB);
		
		float confianzaminimaADB = ((float) tamanoABD / (float) tamanoAD);
		System.out.println("La minima confianza de AD->B es:" + confianzaminimaADB);
		
		float confianzaminimaAEB = ((float) tamanoABE / (float) tamanoAF);
		System.out.println("La minima confianza de AE->B es:" + confianzaminimaAEB);
		
		float confianzaminimaAFB = ((float) tamanoABF / (float) tamanoAF);
		System.out.println("La minima confianza de AF->B es:" + confianzaminimaAFB);
		
		float confianzaminimaCDB = ((float) tamanoBCD / (float) tamanoCD);
		System.out.println("La minima confianza de CD->B es:" + confianzaminimaCDB);
		
		float confianzaminimaCEB = ((float) tamanoBCE / (float) tamanoCE);
		System.out.println("La minima confianza de CE->B es:" + confianzaminimaCEB);
		
		float confianzaminimaCFB = ((float) tamanoBCF / (float) tamanoCF);
		System.out.println("La minima confianza de CF->B es:" + confianzaminimaCFB);
		
		float confianzaminimaDEB = ((float) tamanoBDE / (float) tamanoDE);
		System.out.println("La minima confianza de DE->B es:" + confianzaminimaDEB);
		
		float confianzaminimaDFB = ((float) tamanoBDF / (float) tamanoDF);
		System.out.println("La minima confianza de DF->B es:" + confianzaminimaDFB);
		
		float confianzaminimaEFB = ((float) tamanoBEF / (float) tamanoEF);
		System.out.println("La minima confianza de EF->B es:" + confianzaminimaEFB);
		
		float confianzaminimaABC = ((float) tamanoABC / (float) tamanoAB);
		System.out.println("La minima confianza de AB->C es:" + confianzaminimaABC);
		
		float confianzaminimaADC = ((float) tamanoACD / (float) tamanoAD);
		System.out.println("La minima confianza de AD->C es:" + confianzaminimaADC);
		
		float confianzaminimaAEC = ((float) tamanoACE / (float) tamanoAE);
		System.out.println("La minima confianza de AE->C es:" + confianzaminimaAEC);
		
		float confianzaminimaAFC = ((float) tamanoACF / (float) tamanoAF);
		System.out.println("La minima confianza de AF->C es:" + confianzaminimaAFC);
		
		float confianzaminimaBDC = ((float) tamanoBCD / (float) tamanoBD);
		System.out.println("La minima confianza de BD->C es:" + confianzaminimaBDC);
		
		float confianzaminimaBEC = ((float) tamanoBCE / (float) tamanoBE);
		System.out.println("La minima confianza de BE->C es:" + confianzaminimaBEC);
		
		float confianzaminimaBFC = ((float) tamanoBCF / (float) tamanoBF);
		System.out.println("La minima confianza de BF->C es:" + confianzaminimaBFC);
		
		float confianzaminimaDEC = ((float) tamanoCDE / (float) tamanoDE);
		System.out.println("La minima confianza de DE->C es:" + confianzaminimaDEC);
		
		float confianzaminimaDFC = ((float) tamanoCDF / (float) tamanoDF);
		System.out.println("La minima confianza de DF->C es:" + confianzaminimaDFC);
		
		float confianzaminimaEFC = ((float) tamanoCEF / (float) tamanoEF);
		System.out.println("La minima confianza de EF->C es:" + confianzaminimaEFC);
		
		float confianzaminimaABD = ((float) tamanoABD / (float) tamanoAB);
		System.out.println("La minima confianza de AB->D es:" + confianzaminimaABD);
		
		float confianzaminimaACD = ((float) tamanoACD / (float) tamanoAC);
		System.out.println("La minima confianza de AC->D es:" + confianzaminimaACD);
		
		float confianzaminimaAED = ((float) tamanoADE / (float) tamanoAE);
		System.out.println("La minima confianza de AE->D es:" + confianzaminimaAED);
		
		float confianzaminimaAFD = ((float) tamanoADF / (float) tamanoAF);
		System.out.println("La minima confianza de AF->D es:" + confianzaminimaAFD);
		
		float confianzaminimaBCD = ((float) tamanoBCD / (float) tamanoBC);
		System.out.println("La minima confianza de BC->D es:" + confianzaminimaBCD);
		
		float confianzaminimaBED = ((float) tamanoBDE / (float) tamanoBE);
		System.out.println("La minima confianza de BE->D es:" + confianzaminimaBED);
		
		float confianzaminimaBFD = ((float) tamanoBDF / (float) tamanoBF);
		System.out.println("La minima confianza de BF->D es:" + confianzaminimaBFD);
		
		float confianzaminimaCED = ((float) tamanoCDE / (float) tamanoCE);
		System.out.println("La minima confianza de CE->D es:" + confianzaminimaCED);
		
		float confianzaminimaCFD = ((float) tamanoCDF / (float) tamanoCF);
		System.out.println("La minima confianza de CF->D es:" + confianzaminimaCFD);
		
		float confianzaminimaEFD = ((float) tamanoDEF / (float) tamanoEF);
		System.out.println("La minima confianza de EF->D es:" + confianzaminimaEFD);
		
		float confianzaminimaABE = ((float) tamanoABE / (float) tamanoAB);
		System.out.println("La minima confianza de AB->E es:" + confianzaminimaABE);
		
		float confianzaminimaACE = ((float) tamanoACE / (float) tamanoAC);
		System.out.println("La minima confianza de AC->E es:" + confianzaminimaACE);
		
		float confianzaminimaADE = ((float) tamanoADE / (float) tamanoAD);
		System.out.println("La minima confianza de AE->D es:" + confianzaminimaADE);
		
		float confianzaminimaAFE = ((float) tamanoADE / (float) tamanoAF);
		System.out.println("La minima confianza de AF->E es:" + confianzaminimaAFE);
		
		float confianzaminimaBCE = ((float) tamanoBCE / (float) tamanoBC);
		System.out.println("La minima confianza de BC->E es:" + confianzaminimaBCE);
		
		float confianzaminimaBDE = ((float) tamanoBDE / (float) tamanoBD);
		System.out.println("La minima confianza de BD->E es:" + confianzaminimaBDE);
		
		float confianzaminimaBFE = ((float) tamanoBEF / (float) tamanoBF);
		System.out.println("La minima confianza de BF->E es:" + confianzaminimaBFE);
		
		float confianzaminimaCDE = ((float) tamanoCDE / (float) tamanoCD);
		System.out.println("La minima confianza de CD->E es:" + confianzaminimaCDE);
		
		float confianzaminimaCFE = ((float) tamanoCEF / (float) tamanoCF);
		System.out.println("La minima confianza de CF->E es:" + confianzaminimaCFE);
		
		float confianzaminimaDFE = ((float) tamanoDEF / (float) tamanoDF);
		System.out.println("La minima confianza de DF->E es:" + confianzaminimaDFE);
		
		float confianzaminimaFAB = ((float) tamanoABF / (float) tamanoAB);
		System.out.println("La minima confianza de F->AB es:" + confianzaminimaFAB);
		
		float confianzaminimaFAC = ((float) tamanoACF / (float) tamanoAC);
		System.out.println("La minima confianza de F->AC es:" + confianzaminimaFAC);
		
		float confianzaminimaFAD = ((float) tamanoADF / (float) tamanoAD);
		System.out.println("La minima confianza de F->AD es:" + confianzaminimaFAD);
		
		float confianzaminimaFAE = ((float) tamanoAEF / (float) tamanoAE);
		System.out.println("La minima confianza de F->AE es:" + confianzaminimaFAE);
		
		float confianzaminimaFBC = ((float) tamanoBCF / (float) tamanoBC);
		System.out.println("La minima confianza de F->BC es:" + confianzaminimaFBC);
		
		float confianzaminimaFBD = ((float) tamanoBDF / (float) tamanoBD);
		System.out.println("La minima confianza de F->BD es:" + confianzaminimaFBD);
		
		float confianzaminimaFBE = ((float) tamanoBEF / (float) tamanoBE);
		System.out.println("La minima confianza de F->BE es:" + confianzaminimaFBE);
		
		float confianzaminimaFCD = ((float) tamanoCDF / (float) tamanoCD);
		System.out.println("La minima confianza de F->CD es:" + confianzaminimaFCD);
		
		float confianzaminimaFCE = ((float) tamanoCEF / (float) tamanoCE);
		System.out.println("La minima confianza de F->CE es:" + confianzaminimaFCE);
		
		float confianzaminimaFDE = ((float) tamanoDEF / (float) tamanoDE);
		System.out.println("La minima confianza de F->DE es:" + confianzaminimaFDE);
		
	}

}
