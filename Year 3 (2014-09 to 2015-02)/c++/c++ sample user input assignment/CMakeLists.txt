cmake_minimum_required(VERSION 2.8.4)
project(SchoolAssignment)

set(SRCDIR src)
set(INCDIR include)

set(S_UTILDIR ${SRCDIR}/utils)
set(H_UTILDIR ${INCDIR}/utils)

include_directories(${SRCDIR} ${S_UTILDIR})
include_directories(${INCDIR} ${H_UTILDIR})

set(
    SOURCE_FILES
    ${SRCDIR}/main.cpp
    ${SRCDIR}/exampleinput.cpp ${SRCDIR}/equation.cpp

    ${S_UTILDIR}/stringutils.cpp ${S_UTILDIR}/prompt.cpp

)

set(
    HEADER_FILES
    ${INCDIR}/main.h
    ${INCDIR}/exampleinput.h ${INCDIR}/equation.h

    ${H_UTILDIR}/stringutils.h ${H_UTILDIR}/prompt.h
)

add_executable(
    SchoolAssignment
    ${SOURCE_FILES}
    ${HEADER_FILES}
)

add_definitions(-std=c++11)