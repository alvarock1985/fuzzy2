package main;

public class Methods {
	
	Support xu = new Support();
	
	public double[] addScalar(double[] x, double[] num){
		if(num.length ==1){
			for(int i=0;i<x.length;i++){
				x[i] += num[0];
			}
		}else{
			for(int i=0;i<x.length;i++){
				x[i] += num[i];
			}
		}
		return x;
	}
	
	public double[] multScalar(double[] x, double[] num){
		if(num.length ==1){
			for(int i=0;i<x.length;i++){
				x[i] *= num[0];
			}
		}else{
			for(int i=0;i<x.length;i++){
				x[i] *= num[i];
			}
		}
		return x;
	}
	
	public double[] substractList(double[]x, int[]y){
		double[] aux = new double[5];
		for(int i=0;i<x.length;i++){
			aux[i] = x[i] - y[i];
		}
		
		return aux;
	}
	
	public double[] obtainElem(double[] l, int[] ind){
		double[] aux = new double[5];
		for(int i=0;i<ind.length;i++){
			aux[i] = l[i];
		}
		
		return aux;
	}
	
	public int ceil(double num){
		int aux = (int)num;
		if(num-aux==0){
			return aux;
		}else{
			return aux+1;
		}
	}
	
	public double[] percentile(double[] xe, double[]p){
		
		double[] aux = p;
		double[] x = xu.sortDoubleArray(xe);
		double[] numero = {1};
		double[] aux2 = {(x.length-1)*0.01};
		double[] trim = this.addScalar(this.multScalar(aux, aux2), numero);
		int[] aux3 = xu.dobToInt(trim);
		int[] aux4 = xu.ceilOnList(trim);
		
		double[] delta = this.substractList(trim, aux3);
		int[] deltaInt = xu.dobToInt(delta);
		double[] aux5 = xu.multListInt(numero, delta.length);
		
				
		double[] result = this.addScalar(this.multScalar(this.obtainElem(x, aux3), delta), this.multScalar(this.obtainElem(x, aux4), this.substractList(aux5, deltaInt)));
		
		return result;
	}
	
	
	
	public void linguisticValues(double[][] dd, int nVl){
		int lingVar = 5;
		double[][][] lv = new double[3][3][5];
		int nAtt = 3;
		int delta = 100/(nVl-1);
		double[] p = new double[3];
		int count = 0;
		for(int i=0;i<101;i+=delta){		
			if(i==0){
				count = 0;
				p[count] = i;
			}else{
				count++;
				p[count] = i;
			}
		}
		
		double[][] prc = new double[3][5];
		for(int i=0;i<nAtt;i++){
			prc[i] = this.percentile(dd[i], p);
		}
		
		System.out.println(prc[0][2]);
		double[][][] lV = new double[3][5][3];
		for(int i=0;i<nAtt;i++){
			
			for(int j=0;i<lingVar-2;j++){
				
			}
		}
		
		
	}

}
