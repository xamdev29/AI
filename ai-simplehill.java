public class aisimplehill {
	// Penghitungan Jarak Terpendek
	static int jarak[][] = {
		{6, 10, 8, 7}, // Jarak A ke B, C, D, E
		{11, 5, 9}, // Jarak B ke C, D, E
		{6, 3}, // Jarak C ke D, E
		{4} // Jarak D ke E
	};
	static int data[] = {4, 1, 3, 0, 2}; // 0 1 2 3 4 untuk A B C D E  
	static int node[] = {0, 0, 0, 0, 0};
	
	public static void main(String[] args) {
		System.out.println("- Jarak Terpendek -");
		System.out.println("- Heuristic | Simple Hillclimb -");
		System.out.println("- Acuan | 1,2 | 1,3 | 1,4 | 1,5 | 2,3 | 2,4 | 2,5 | 3,4 | 3,5 | 4,5 | -");
		
		boolean cek = true;
		boolean j_cek = true;
		int t_node[] = {0, 0, 0, 0, 0}; // Temp Node
		int t_jarak = h_jarak(data); // Temp Jarak
		int j_temp = t_jarak; // Temp Perhitungan Jarak
		
		while(cek == true) {
			if(j_cek == false) {
				for(int z = 0; z < t_node.length; z++) {
					data[z] = t_node[z];
				}
				t_jarak = j_temp;
				j_cek = true;
			}
			int j = h_jarak(data); // Hitung Jarak
			
			String t = h_label(data); // Tampilkan Label
			System.out.println("[" + t + "] (" + j + ")");
			
			// Pengubahan posisi node
			// Acuan 01 02 03 04 12 13 14 23 24 34
			for(int x = 0; x < data.length - 1; x++) {
				for(int y = x + 1; y < data.length; y++) {
					if(j_cek == true) { // Cek Jarak
						h_node(); // Mengubah Value urutan Node
						
						int temp = node[x];
						node[x] = node[y];
						node[y] = temp;
								
						j = h_jarak(node); // Hitung Jarak
						t = h_label(node); // Tampilkan Label
	
						System.out.println(" -> [" + t + "] (" + j + ") ");
						
						if(j < t_jarak) {
							j_temp = j;
							for(int z = 0; z < t_node.length; z++) {
								t_node[z] = node[z];
							}
							j_cek = false;
						}
					}
				}
			}
			if(t_jarak == j_temp) cek = false;
		}
	}
	public static void h_node() {
		for(int x = 0; x < data.length; x++) {
			node[x] = data[x];
		}
	}
	public static int h_jarak(int[] d) {
		int j = 0;
		int nx, ny;
		for(int x = 0; x < d.length - 1; x++) {
			nx = Math.max(d[x], d[x + 1]);
			ny = Math.min(d[x], d[x + 1]);
			
			j += jarak[ny][nx - ny - 1];
		}
		return j;
	}
	public static String h_label(int d[]) {
		String text[] = {"A", "B", "C", "D", "E", "F"};
		String t = "";
		for(int x = 0; x < d.length; x++) {
			t += text[d[x]];
		}
		return t;
	}
}
