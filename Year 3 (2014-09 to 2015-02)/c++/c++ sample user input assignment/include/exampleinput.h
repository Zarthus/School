#ifndef __exampleinput_H_
#define __exampleinput_H_

#include <iostream>
#include <stringutils.h>
#include <prompt.h>

class ExampleInput
{
public:
    ExampleInput();
    ~ExampleInput();

    std::string getInput();
    std::string getInput(std::string prompt);

    unsigned int getInteger();
    unsigned int getInteger(std::string prompt);
};

#endif //__exampleinput_H_
