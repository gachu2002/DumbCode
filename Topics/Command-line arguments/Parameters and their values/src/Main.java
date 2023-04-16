class Problem {
    public static void main(String[] args) {
        String[] par = new String[args.length / 2];
        String[] val = new String[args.length / 2];
        for (int i = 0; i < args.length; i += 2) {
            par[i / 2] = args[i];
            val[i / 2] = args[i + 1];
        }
        for (int i = 0; i < par.length; i ++) {
            System.out.println(par[i] + "=" + val[i]);
        }
    }
}