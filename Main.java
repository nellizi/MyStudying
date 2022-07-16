class Main {
    public static void main(String[] args) {
        ArrayList ar = new ArrayList();
        ar.add(100, 0);
        ar.add(200, 1);
        ar.add(300, 2);
        ar.add(400, 3);
        ar.add(500, 4);
        ar.add(600, 2); // 2번좌석으로 새치기, 기존의 2번좌석 손님부터 끝 손님까지 뒤로 한칸씩 밀린다.
        ar.add(700, 0); // 0번좌석으로 새치기, 기존의 0번좌석 손님부터 끝 손님까지 뒤로 한칸씩 밀린다.

        for ( int i = 0; i < ar.size(); i++ ) {
            int value = (int)ar.get(i);

            System.out.println(i + " : " + value);
        }

        // 출력
        // 0 : 700
        // 1 : 100
        // 2 : 200
        // 3 : 600
        // 4 : 300
        // 5 : 400
        // 6 : 500
    }
}

class ArrayList {
    int[] datas;
    int lastIndex = -1;

    ArrayList() {
        datas = new int[3]; // 이 부분은 수정할 수 없습니다.
    }

    void add(int data, int index) {

        extendDatasSizeIfNeed();

        if(datas[index]!=0){
            for (int i =lastIndex; i>=index; i--){
                datas[i + 1] = datas[i] ;}

        }
        datas[index] = data;
        lastIndex++;
    }

    void add(int data) {
        extendDatasSizeIfNeed();

        lastIndex++;

        datas[lastIndex] = data;
    }

    void extendDatasSizeIfNeed() {
        if ( lastIndex + 1 >= datas.length ) {

            int[] newArr = new int[datas.length * 2];

            for ( int i = 0; i < datas.length; i++ ) {
                newArr[i] = datas[i];
            }

            datas = newArr;
        }
    }

    int get(int index) {
        return datas[index];
    }

    int size() {
        return lastIndex + 1;
    }
}