package main;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Methods met = new Methods();
		int alphaIni = 10;
		double rho = 0.05;
		int tolerance = 2;
		int maxVlCambian =1;
		int[] delta = {1,1,1};
		int[] driftDetectado = {0,0,0};
		Support xu = new Support();
		
		int linguisticVarNumber = 5;
		//int nAtt = 3;
		double[] wUser = {0.4,0.3,0.2};
		String[] criteria = {"least", "least" ,"most"};
		int[] userRequiredLevel = {4,4,2};
		
		String[] resources = {"x1","x2","x3","x4","x5"};
		String[] attributes = {"benefit", "benefit", "cost"};
		
		
		double[][] x1 = {{0.75,0.85,0.50 },{0.80,0.90,0.45},{0.90,0.85,0.30}};
		double[][] x2 = {{0.95,0.70,0.45},{0.90,0.85,0.40},{0.85,0.90,0.35}};
		double[][] x3 = {{0.80,0.90,0.35},{0.85,0.80,0.40},{0.95,0.85,0.45}};
		double[][] x4 = {{0.90,0.80,0.40},{0.85,0.75,0.50},{0.90,0.80,0.45}};
		double[][] x5 = {{0.85,0.85,0.55},{0.90,0.90,0.60},{0.95,0.85,0.50}};
		
		ArrayList<double[][]> allData = new ArrayList<>();
		allData.add(x1);
		allData.add(x2);
		allData.add(x3);
		allData.add(x4);
		allData.add(x5);
		ArrayList<Double> norm = new ArrayList<>();
		
		int horizonTime = 3;
		int nResources = resources.length;
		int nAtt = attributes.length;
		double[][][] decision = new double[3][3][5];
		
		for(int i=0;i<horizonTime;i++){
			double[][] aux = null;
			for(int a=0;a<nAtt;a++){
				 for(int b =0;b<nResources;b++){
					 aux = allData.get(b);				
					 decision[i][a][b] = aux[i][a]; 
				 }
			}
		}
		
		double[][][] normal = new double[3][3][5];
		for(int t=0;t<horizonTime;t++){
			double[][] aux = new double[1][1];
			for(int a=0;a<nAtt;a++){
				for(int x=0;x<nResources;x++){
					double max = xu.getMax(decision[t][a]);
					double min = xu.getMin(decision[t][a]);
					if(attributes[a] == "benefit"){
						normal[t][a][x] = Math.round((decision[t][a][x]/max)*10000)/10000d;
					}else{
						normal[t][a][x] = Math.round((min/decision[t][a][x])*10000)/10000d;
					}					
				}
			}
		}
		
		int delta2 = 100/(5-1);
		int[] p = new int[5];
		int count = 0;
		
		
		double[][] dd = {{0.7895, 1.0, 0.8421, 0.9474, 0.8947}, {0.9444, 0.7778, 1.0, 0.8889, 0.9444}, {0.7, 0.7778, 1.0, 0.875, 0.6364}};
		
		met.linguisticValues(dd, 3);
		
		

	}

}
