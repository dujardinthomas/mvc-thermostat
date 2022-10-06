package fr.univlille.iutinfo.r3_04.utils;

public interface Observer {
        public void update(Subject subj);
        public void update(Subject subj, Object data);
		void changeValues(double v);
}
