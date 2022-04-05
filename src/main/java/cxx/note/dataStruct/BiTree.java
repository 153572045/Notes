package cxx.note.dataStruct;

public class BiTree {

    /**
     * 根节点
     */
    public Note root;

    /**
     * 为二叉树插入节点
     * @param note
     * @param data
     * @return
     */
    public boolean add(Note note, Integer data) {
        if(note == null) {
            note = new Note(data, null, null);
            return true;
        }
        if(note.data == data) {
            System.out.println("there is a same data");
            return false;
        }
        else if(note.data < data) {
            return add(note.right, data);
        }

        return add(note.left, data);
    }

    /**
     * 初始化二叉树
     * @param dataSet
     */
    public void initBiSortTree(int[] dataSet) {
        if(dataSet == null || dataSet.length == 0) {
            return ;
        }
        for(int i = 0; i < dataSet.length; i++) {
            add(root, dataSet[i]);
        }
    }

    /**
     * 二叉树查找节点
     * @param key
     * @return
     */
    public Note search(int key) {
        Note N = root;
        while (N != null) {
            if (N.data == key) {
                return N;
            }
            else if(N.data < key) {
                N = N.right;
            } else {
                N = N.left;
            }
        }
        return N;
    }




    public class Note {
        public Integer data;
        public Note left;
        public Note right;

        public Note(Integer data, Note left, Note right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Note(Note note) {
            this.data = note.data;
            this.left = note.left;
            this.right = note.right;
        }
    }
}
