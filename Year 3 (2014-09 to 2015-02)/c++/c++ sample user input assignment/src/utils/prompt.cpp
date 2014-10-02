#include <prompt.h>

void Prompt::prompt(std::string p)
{
    std::cout << p << std::endl << "> ";
}

std::string Prompt::promptInput(std::string p)
{
    std::string input;

    std::cout << p << std::endl;
    for (int i = 0; i < 100; i++) {
        std::cout << "> ";
        std::cin >> input;

        if (!std::cin) {
            std::cout << "Erroneous input, try again." << std::endl;
            continue;
        } else if (StringUtils::bicompare(input, "repeat")) {
            std::cout << p << std::endl;
            continue;
        }
        break;
    }

    return input;
}