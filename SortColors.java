import java.util.ArrayList;
import java.util.List;

public class SortColors {
    public static void sortColors(int[] colors){
        int z = 0, o = 0, t = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < colors.length; i++){
            if(colors[i] == 0){
                list.add(z, 0);
                z++;
            }else if(colors[i] == 1){
                list.add(z+o, 1);
                o++;
            }else {
                list.add(z+o+t, 2);
                t++;
            }
        }
        System.out.println(list);;
    }

    public static void sortCOLORS(int[] colors){
        if(colors == null || colors.length <= 0)
            return;
        int n = colors.length;
        int pz = 0, po = 0, pt = 0;
        for(int i = 1; i < n; i++){
            if(colors[i] != colors[i-1]){
                if(colors[i] == 0){
                    int temp = colors[i];
                    colors[i] = colors[pz];
                    colors[pz] = temp;
                    if(colors[i] == 1)
                        po--;
                    i = pz+po+pt;
                    pz++;
                }else if(colors[i] == 1){
                    int temp = colors[i];
                    colors[i] = colors[po+pz];
                    colors[pz + po] = temp;

                    i = po+pz+pt;
                    po++;
                }else{
                    /*
                    int temp = colors[i];
                    colors[i] = colors[pz+po+pt];
                    colors[po+pz+pt] = temp;

                     */
                    //i ;
                    pt++;

                }
            }
        }
        for(int i : colors){
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] ar = {2,0,1,0,2,0,2,1,0,2,1,1,0,2,1,2,1,1,2,0,0};
        sortColors(ar);
        sortCOLORS(ar);
    }
}
