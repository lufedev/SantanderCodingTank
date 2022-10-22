
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.exit;


class tempConverter{
    static Scanner sc = new Scanner(System.in); // Scanner Class
    static void converter(Double final_val, Double init_val, String init_temp, String final_temp){
        System.out.printf("Valor inicial: %.2f %s | Valor final: %.2f %s \n",init_val,init_temp,final_val,final_temp);
    }
    static void media(Double media_inicial, Double media_final, String unidade_inicial,String unidade_final){
        System.out.printf("Media total inicial: %.2f %s | Media total final: %.2f %s \n",media_inicial,unidade_inicial,media_final,unidade_final);
    }

    // Driver Method
    public static void main(String args[]){
        boolean continuar;
        Double C,F,K,conversao = null;
        Double media_inicial = 0.0, media_final = 0.0;
        String unidade_inicial = null ,unidade_final = null;
        int tipo = 0,qttd = 0;
        do{
            while(true) {
                System.out.println(
                        """
                                1. Celsius para Fahrenheit
                                2. Celsius para Kelvin
                                3. Fahrenheit para Celsius
                                4. Fahrenheit para Kelvin
                                5. Kelvin para Celsius
                                6. Kelvin para Fahrenheit
                                """);

                System.out.println("\nEscolha sua conversão: ");
                try {
                    tipo = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido execute o programa novamente!!");
                    exit(1);
                }
                if (tipo > 10 || tipo < 0) {

                    System.out.print("\nValor Inválido Insira Novamente!!!\n");
                }
                else {
                    break;
                }
            }

            System.out.println("\nEscolha a quantidade de valores: ");

            try {
                qttd = sc.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Valor inválido execute o programa novamente!!");
                exit(1);
            }

            Double[] val = new Double[qttd];
            Double[] tmp_final = new Double[qttd];


            for (int i = 0; i < qttd ; i++) {
                System.out.printf("Insira o valor %d: \n",i+1);
                val[i] = sc.nextDouble();
            }

            System.out.print("\n============= VALORES CONVERTIDOS ===============\n");

            for (int j = 0; j < val.length; j++) {
                switch (tipo) {
                    case 1 -> {
                        C = val[j];
                        conversao = C * (9 / 5f) + 32;
                        unidade_inicial = "°C";
                        unidade_final = "°F";
                        converter(conversao, val[j], unidade_inicial, unidade_final);
                    }
                    case 2 -> {
                        C = val[j];
                        conversao = C + 273.15;
                        unidade_inicial = "°C";
                        unidade_final = " K";
                        converter(conversao, val[j], unidade_inicial, unidade_final);
                    }
                    case 3 -> {
                        F = val[j];
                        conversao = (F - 32) * 5 / 9f;
                        unidade_inicial = "°F";
                        unidade_final = "°C";
                        converter(conversao, val[j], unidade_inicial, unidade_final);
                    }
                    case 4 -> {
                        F = val[j];
                        conversao = (F - 32) * 5 / 9f + 273.15;
                        unidade_inicial = "°F";
                        unidade_final = " K";
                        converter(conversao, val[j], unidade_inicial, unidade_final);
                    }
                    case 5 -> {
                        K = val[j];
                        conversao = K - 273.15;
                        unidade_inicial = " K";
                        unidade_final = "°C";
                        converter(conversao, val[j], unidade_inicial, unidade_final);
                    }
                    case 6 -> {
                        K = val[j];
                        conversao = (K - 273.15) * 9 / 5f + 32;
                        unidade_inicial = " K";
                        unidade_final = "°F";
                        converter(conversao, val[j], unidade_inicial, unidade_final);
                    }
                }
                tmp_final[j] = conversao;
            }
            //Começo do cálculo das médias finais
            for (int i = 0; i < qttd; i++) {
                 media_inicial += val[i];
                 media_final += tmp_final[i];
            }

            System.out.println("============= MÉDIA DOS VALORES =================");
            media((media_inicial /= qttd), (media_final /= qttd), unidade_inicial ,unidade_final) ;
            //Fim do cálculo das médias finais

            //Deseja continuar o programa?
            System.out.print("\nPara continuar tecle 's', para sair aperte qualquer outro botão. " );
            char c = sc.next().charAt(0);
            continuar = c == 's';


        }
        while(continuar);
    }
}
