#ifndef __equation_H_
#define __equation_H_

#include <iostream>
#include <random>
#include <sstream>

class Equation
{
public:
    Equation();
    ~Equation();

    int getAnswer();
    std::string getEquation();
protected:
    void generate();
    void generate(int max);

    int answer;
    std::string equation;
};

#endif //__equation_H_
