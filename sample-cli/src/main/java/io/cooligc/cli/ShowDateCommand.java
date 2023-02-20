package io.cooligc.cli;


import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.concurrent.Callable;


@Command(name="show-date", description = "show the current date-time")
public class ShowDateCommand implements Callable<String> {

    @Option(names = {"-formatter","--formater"} , description = "date-time format")
    private String dateFormat;



    @Option(names = {"-user","--user"} , description = "date-time format")
    private String userName;


    @Override
    public String call() throws Exception {

        String format = Objects.isNull(dateFormat) ? DateTimeFormatter.ISO_DATE.toString() :  dateFormat;

        System.out.println(format +"\t\t"+ userName);

        return LocalDate.now().format(DateTimeFormatter.ISO_DATE);
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ShowDateCommand()).execute(args);
        System.out.println(exitCode);
    }
}
