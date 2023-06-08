interface Liste<T> {
	int size();
	void add(T x);
	void set(int pos, T x);
	T get(int pos);
	T remove(int pos);
}