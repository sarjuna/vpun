package Latency;

public class EstimatedRTT {
private double RTT=Double.MIN_VALUE;

private final double alpha = 0.875;

public double estimate(double newValue){
	
	if(RTT == Double.MIN_VALUE) {
		RTT=newValue;
		return RTT;
	}
	
	RTT = alpha*RTT+(1-alpha)*newValue;
	return RTT;
	
}

}
