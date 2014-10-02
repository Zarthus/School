#include <equation.h>

Equation::Equation() {
    generate();
}

Equation::~Equation() {

}

int Equation::getAnswer() {
    return answer;
}

std::string Equation::getEquation() {
    return equation;
}

void Equation::generate() {
    generate(10000);
}

void Equation::generate(int max) {
    answer = (rand() % max) + 2; // 0 and 1 are used for quitting / repeating the question

    int q1 = rand() % answer;
    int q2 = answer - q1;

    std::stringstream s;

    s << q1 << " + " << q2;
    equation = s.str();
}
