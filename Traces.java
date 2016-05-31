package senCity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public abstract class Traces extends AbstractTraces implements Iterable<Trace>{


	public int taille(){
		return list.size();
	}


}
