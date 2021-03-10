package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;



public class Main {
	Scanner Input = new Scanner(System.in);
	Random rand = new Random();
	ArrayList<Data> ListData = new ArrayList<Data>();
	ArrayList<Double> GajiList = new ArrayList<Double>();
	ArrayList<String> JabatanList = new ArrayList<String>();
	
	void menuutama() {
		System.out.println("PT. Mentol");
		System.out.println("1. Insert data karyawan");
		System.out.println("2. View data karyawan");
		System.out.println("3. Update data karyawan");
		System.out.println("4. Delete data karyawan");
		System.out.print(">> ");
	}

	public Main() {
		int pilih,count=0,count2=0,count3=0,hitung=0, koma=0, koma2=0, koma3=0, update, delete, tambah=0;
		double countt=0, countt2=0, countt3=0;
		String name="";
		String kelamin="";
		String jabatan="";
		double gaji=0;
		String cek="";
		String id="";
		String id2="";
		int gajibaru=0, tambah2=0, tambah3=0, flag=-1, urutan=0, ganti=0;
		String kodebaru="";
		String kodelama="";
		
		do {
		menuutama();
		
		pilih=Input.nextInt();Input.nextLine();
		if(pilih==1) {
			flag++;
			hitung++;
			do {
			System.out.print("Input nama karyawan [ >=3 ]: ");
			name=Input.nextLine();
			}while(name.length()<3);
			
			do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			kelamin=Input.nextLine();
			}while(kelamin.charAt(0)!='P' && kelamin.charAt(0)!='L');
			
			do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan=Input.nextLine();
			
			id="";
			
			for (int i = 0; i < 2; i++) {
				id += (char)(rand.nextInt(26)+65);
			}
			
			id=id.concat("-");

			for (int i = 0; i < 4; i++) {
				id += rand.nextInt(10);
			}

			System.out.printf("Berhasil menambahkan karyawan dengan id %s\n",id);
			
			if(jabatan.equals("Manager")) {
				count++;
				gaji=8000000;
				JabatanList.add("a");
				GajiList.add(gaji);
				tambah++;
				if(count>3) {
					System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id ");
					for(int j=0; j<hitung-1; j++) {
						urutan=ListData.get(j).getFlag();
						cek=JabatanList.get(urutan);
						if(cek.equals("a")) {
							System.out.printf("%s",ListData.get(j).getid());
							koma++;
							if(koma+1==tambah) {
								System.out.println("");
								koma=0;
							}else {
								System.out.print(", ");
								
							}
							urutan=ListData.get(j).getFlag();
							countt=GajiList.get(urutan);
							GajiList.set(urutan, (countt+(countt*0.1)));
					
						}
					}
					count=1;
				}
			}else if(jabatan.equals("Supervisor")) {
				count2++;
				gaji=6000000;
				JabatanList.add("b");
				GajiList.add(gaji);
				tambah2++;
				if(count2>3) {
					System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ");

					for(int k=0; k<hitung-1; k++) {
						urutan=ListData.get(k).getFlag();
						cek=JabatanList.get(urutan);
						if(cek.equals("b")) {
							System.out.printf("%s",ListData.get(k).getid());
							koma2++;
							if(koma2+1==tambah2) {
								System.out.println("");
								koma2=0;
							}else {
								System.out.print(", ");
								
							}
							urutan=ListData.get(k).getFlag();
							countt2=GajiList.get(urutan);
							GajiList.set(urutan, (countt2+(countt2*0.075)));
						}
					}
					count2=1;
				}
			}else if(jabatan.equals("Admin")){
				count3++;
				gaji=4000000;
				JabatanList.add("c");
				GajiList.add(gaji);
				tambah3++;
				if(count3>3) {
					System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id ");
					for(int f=0; f<hitung-1; f++) {
						urutan=ListData.get(f).getFlag();
						cek=JabatanList.get(urutan);
						if(cek.equals("c")) {
							System.out.printf("%s",ListData.get(f).getid());
							koma3++;
							if(koma3+1==tambah3) {
								System.out.println("");
								koma3=0;
							}else {
								System.out.print(", ");
								
							}
							urutan=ListData.get(f).getFlag();
							countt3=GajiList.get(urutan);
							GajiList.set(urutan, (countt3+(countt3*0.05)));
						}
					}
					count3=1;
				}
			}
			}while(jabatan.charAt(0)!='M' && jabatan.charAt(0)!='S' && jabatan.charAt(0)!='A');
			

			System.out.println("ENTER to return");
			Input.nextLine();
			
			Data datapekerja = new Data(id,name,kelamin,jabatan,flag);
			ListData.add(datapekerja);
			
			
		}else if(pilih==2) {
			Collections.sort(ListData, new Sorting());
			if(ListData.size()==0) {
				System.out.println("Data tidak ada");
			}
			else {
			System.out.println("|----|-----------------|------------------------------|------------------|------------------|-------------------|");
			System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin     |Jabatan           |Gaji Karyawan      |");
			System.out.println("|----|-----------------|------------------------------|------------------|------------------|-------------------|");
			
	
			
			
			for(int idx=0; idx<ListData.size(); idx++) {
				urutan=ListData.get(idx).getFlag();
				System.out.printf("| %2d | %15s | %28s | %16s | %16s | %17.0f |\n",idx+1,ListData.get(idx).getid(),ListData.get(idx).getName(),ListData.get(idx).getKelamin(),ListData.get(idx).getJabatan(),GajiList.get(urutan));
			}
			System.out.println("|----|-----------------|------------------------------|------------------|------------------|-------------------|");
		}
		}else if(pilih==3) {
			if(ListData.size()==0) {
				System.out.println("Data tidak ada");
			}
			else {
			System.out.println("|----|-----------------|------------------------------|------------------|------------------|-------------------|");
			System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin     |Jabatan           |Gaji Karyawan      |");
			System.out.println("|----|-----------------|------------------------------|------------------|------------------|-------------------|");
			
			Collections.sort(ListData, new Comparator<Data>() {

				@Override
				public int compare(Data arg0, Data arg1) {
					// TODO Auto-generated method stub
					return 0;
				}
				
			});
			
			
			for(int idx=0; idx<ListData.size(); idx++) {
				System.out.printf("| %2d | %15s | %28s | %16s | %16s | %17.0f |\n",idx+1,ListData.get(idx).getid(),ListData.get(idx).getName(),ListData.get(idx).getKelamin(),ListData.get(idx).getJabatan(),GajiList.get(idx));
			}
		}
			do {
				System.out.println("Masukkan nomor yang mau di update [1.."+ ListData.size() +"] : ");
				update = Input.nextInt(); Input.nextLine();
			}while(update <1 ||update >ListData.size());
			
			System.out.print("Masukkan id baru: ");
			id=Input.nextLine();
			
			do {
				System.out.print("Input nama karyawan [ >=3 ]: ");
				name=Input.nextLine();
				}while(name.length()<3);
				
				do {
				System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
				kelamin=Input.nextLine();
				}while(kelamin.charAt(0)!='P' && kelamin.charAt(0)!='L');
				
				do {
					System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
					jabatan=Input.nextLine();
					if(jabatan.equals("Manager")) {
						urutan=ListData.get(update-1).getFlag();
						count++;
						tambah++;
						JabatanList.set(update-1, "a");
						if(count>3) {
							System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id ");
							for(int j=0; j<hitung-1; j++) {
								urutan=ListData.get(j).getFlag();
								cek=JabatanList.get(urutan);
								if(cek.equals("a")) {
									System.out.printf("%s",ListData.get(j).getid());
									koma++;
									if(koma+1==tambah) {
										System.out.println("");
										koma=0;
									}else {
										System.out.print(", ");
										
									}
									urutan=ListData.get(j).getFlag();
									countt=GajiList.get(urutan);
									GajiList.set(urutan, (countt+(countt*0.1)));
							
								}
							}
							count=1;
						}
					}else if(jabatan.equals("Supervisor")) {
						urutan=ListData.get(update-1).getFlag();
						JabatanList.set(update-1, "b");
						count2++;
						tambah2++;
						
						if(count2>3) {
							System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ");

							for(int k=0; k<hitung-1; k++) {
								urutan=ListData.get(k).getFlag();
								cek=JabatanList.get(urutan);
								if(cek.equals("b")) {
									System.out.printf("%s",ListData.get(k).getid());
									koma2++;
									if(koma2+1==tambah2) {
										System.out.println("");
										koma2=0;
									}else {
										System.out.print(", ");
										
									}
									urutan=ListData.get(k).getFlag();
									countt2=GajiList.get(urutan);
									GajiList.set(urutan, (countt2+(countt2*0.075)));
								}
							}
							count2=1;
						}
						
					}else if(jabatan.equals("Admin")) {
						urutan=ListData.get(update-1).getFlag();
						JabatanList.set(update-1, "c");
						count3++;
						tambah3++;
						
						if(count3>3) {
							System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id ");
							for(int f=0; f<hitung-1; f++) {
								urutan=ListData.get(f).getFlag();
								cek=JabatanList.get(urutan);
								if(cek.equals("c")) {
									System.out.printf("%s",ListData.get(f).getid());
									koma3++;
									if(koma3+1==tambah3) {
										System.out.println("");
										koma3=0;
									}else {
										System.out.print(", ");
										
									}
									urutan=ListData.get(f).getFlag();
									countt3=GajiList.get(urutan);
									GajiList.set(urutan, (countt3+(countt3*0.05)));
								}
							}
							count3=1;
						}
					}
				}while(jabatan.charAt(0)!='M' && jabatan.charAt(0)!='S' && jabatan.charAt(0)!='A');
				
				
				
				System.out.print("Masukkan gaji baru: ");
				gaji=Input.nextDouble();
				urutan=ListData.get(update-1).getFlag();
				GajiList.set(urutan, gaji);
				
				ListData.get(update-1).setID(id);
				ListData.get(update-1).setName(name);
				ListData.get(update-1).setKelamin(kelamin);
				ListData.get(update-1).setJabatan(jabatan);

				
				
				
				
				
		}else if(pilih==4) {
			if(ListData.size()==0) {
				System.out.println("Data tidak ada");
			}
			else {
			System.out.println("|----|-----------------|------------------------------|------------------|------------------|-------------------|");
			System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin     |Jabatan           |Gaji Karyawan      |");
			System.out.println("|----|-----------------|------------------------------|------------------|------------------|-------------------|");
			
			Collections.sort(ListData, new Comparator<Data>() {

				@Override
				public int compare(Data arg0, Data arg1) {
					// TODO Auto-generated method stub
					return arg0.getName().compareTo(arg1.getName());
				}
				
			});
			
			
			for(int idx=0; idx<ListData.size(); idx++) {
				System.out.printf("| %2d | %15s | %28s | %16s | %16s | %17.0f |\n",idx+1,ListData.get(idx).getid(),ListData.get(idx).getName(),ListData.get(idx).getKelamin(),ListData.get(idx).getJabatan(),GajiList.get(idx));
			}
		}
			
			do {
				System.out.print("Masukkan nomor yang mau di delete [1.."+ ListData.size() +"] :  ");
				delete = Input.nextInt(); Input.nextLine();
				urutan=ListData.get(delete-1).getFlag();
				
				if(JabatanList.get(urutan).equals("a")) {
					tambah-=1;
				}
				else if(JabatanList.get(urutan).equals("b")) {
					tambah2-=1;
				}
				else if(JabatanList.get(urutan).equals("c")) {
					tambah3-=1;
				}
			}while(delete <1 ||delete >ListData.size());
			
			ListData.remove(delete-1);
		}
		
	}while(pilih<=4);
		
	}

	public static void main(String[] args) {
		new Main();

	}

}
