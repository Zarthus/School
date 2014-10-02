#ifndef __prompt_H_
#define __prompt_H_

#include <iostream>
#include <stringutils.h>

class Prompt
{
public:
    static void prompt(std::string p);
    static std::string promptInput(std::string p);
};

#endif //__prompt_H_