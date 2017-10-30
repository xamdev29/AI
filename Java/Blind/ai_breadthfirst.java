/*==============================================================
Pencarian Buta ( Blind Search )
	- Pencarian file pada sebuah Folder
	- Menggunakan Algoritma Breadth First Search
================================================================*/
public class ai_breadthfirst {
	public static void main(String[] args) {
		String data[][] = {
				{"Drive C", "Smt 4", "Program Files"}, // isi didalam Folder "Drive C"
				
					{"Smt 4", "Sister", "Mobile"}, // isi didalam Folder "Smt 4"
						{"Sister", "modul1.pdf", "Data Prak"}, // isi didalam Folder "Sister"
							{"Data Prak", "tugas1.java", "jurnal.pdf"}, // isi didalam Folder "Data Prak"
							
						{"Mobile", "Praktikum"}, // isi didalam Folder "Mobile"
							{"Praktikum", "Data Lab", "Ionic"}, // isi didalam Folder "Praktikum"
							
					{"Program Files", "Fire Fox", "Chrome"}, // File - file didalam Folder "Program Files"
						{"Fire Fox", "bin"},  // isi didalam Folder "Fire Fox"
							{"bin2", "firefox.exe", "sls.dll"}, // File didalam folder "bin"
							
						{"Chrome", "app", "cache"},  // isi didalam Folder "Chrome"
							{"app", "chrome", "read.txt"},  // isi didalam Folder "app"
							{"cache", "ref.temp"}  // isi didalam Folder "cache"
		};

		String root = "Chrome"; // Folder Root
		String cari = "read.txt"; // File yang dicari
		
		String temp[] = new String[0]; // Temporary untuk menampung Root Folder (sementara)
		String slc_root[] = {root}; // Node Awal - Root Folder
		System.out.println("Mencari : " + cari + " - Dari folder : " + root);
		
		for(int z = 0; z < 20; z++) {
			for(int a = 0; a < slc_root.length; a++) {
				int data_folder = -1;
				for(int b = 0; b < data.length; b++) { // Cari Root File
					if(data[b][0] == slc_root[a]) data_folder = b;
				}
				System.out.println(slc_root[a]);
				
				if(data_folder == -1) continue;
				
				for(int c = 1; c < data[data_folder].length; c++) { // Mendata File Dalam Folder
					temp = add(temp, data[data_folder][c]); // Didata dalam Temporary
					System.out.println("|_  "  + data[data_folder][c]);
					if(data[data_folder][c] == cari) {
						System.out.println("Data Ditemukan..");
						System.exit(0);
					}
				}
				System.out.println("");
			}
			slc_root = temp;
			temp = new String[0];
		}
	}
	// Menambahkan Data untuk menyimpan nama Folder yang akan dicari
	public static String[] add(String data[], String val) {
		String newData[] = new String[data.length + 1];
		for(int n = 0; n < data.length; n++) {
			newData[n] = data[n];
		}
		newData[data.length] = val;
		
		return newData;
	}
}
