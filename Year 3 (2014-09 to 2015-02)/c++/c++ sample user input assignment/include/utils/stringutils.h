#ifndef __StringUtils_H_
#define __StringUtils_H_


#ifndef __utils_H_
#define __utils_H_

#include <iostream>
#include <string>
#include <algorithm>

class StringUtils
{
public:
    StringUtils();
    ~StringUtils();

    static std::string tolower(const std::string str);
    static std::string toupper(const std::string str);
    static int icompare(const std::string str1, const std::string str2);
    static bool bicompare(const std::string str1, const std::string str2);
};

#endif //__utils_H_
#endif //__StringUtils_H_
