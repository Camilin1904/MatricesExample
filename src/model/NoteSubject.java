package model;

public class NoteSubject {
        private String nameNote;
        private double valueNote;
        private String nameSubject;
        private int creditsSubject;
        
        public NoteSubject(String nameNote, double valueNote, String nameSubject, int creditsSubject){
            this.creditsSubject =  creditsSubject;
            this.nameNote = nameNote;
            this.nameSubject = nameSubject;
            this.valueNote  = valueNote;
        }

        public double getValueNote() {
            return valueNote;
        }

        public int getCreditsSubject() {
            return creditsSubject;
        }
        public String getSubject() {
            return nameSubject;
        }
        public String getNameNote() {
            return nameNote;
        }
}
