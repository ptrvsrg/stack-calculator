package ru.nsu.ccfit.petrov.task2.command;

import ru.nsu.ccfit.petrov.task2.Context;
import ru.nsu.ccfit.petrov.task2.command.exception.ArgumentsNumberException;

import java.io.IOException;
import java.util.List;

public class Print
        implements Command
{
    @Override
    public void setArgs(List <String> args)
    {
        if (!args.isEmpty())
            throw new ArgumentsNumberException();
    }

    @Override
    public void run(Context context)
    {
        Double value = context.peekCalculatingValue();
        if (value != null)
            try
            {
                context.getOut().write(value.toString().getBytes());
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
    }
}