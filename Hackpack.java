static long nCk(int n, int k) {
		if (k>n) throw null;
		return mul(facts[n], mul(factInvs[k], factInvs[n-k]));
	}
	
	static long add(long a, long b) {
		return (a+b)%mod;
	}
	static long sub(long a, long b) {
		return ((a-b)%mod+mod)%mod;
	}
	static long mul(long a, long b) {
		return (a*b)%mod;
	}
	static long fastPow(long base, long e) {
		if (e==0) return 1;
		long half=fastPow(base, e/2);
		if (e%2==0) return mul(half, half);
		return mul(half, mul(half, base));
	}
	
	static long[] facts=new long[1_000_00];
	static long[] factInvs=new long[1_000_00];
	static void precomp() {
		facts[0]=1;
		for (int i=1; i<facts.length; i++) facts[i]=mul(facts[i-1], i);
		for (int i=0; i<factInvs.length; i++) factInvs[i]=fastPow(facts[i], mod-2);
		nWaysToPlaceGroupOfSize=new long[500];
		for (int finalSize=1; finalSize<nWaysToPlaceGroupOfSize.length; finalSize++) {
			for (int firstPos=0; firstPos<finalSize; firstPos++) {
				int l=firstPos, r=finalSize-1-firstPos;
				nWaysToPlaceGroupOfSize[finalSize]=add(nWaysToPlaceGroupOfSize[finalSize], nCk(l+r, l));
			}
		}
		System.err.println("Done with precomp.");
	}

