OBJ = ./obj/
SRC = ./src/
LIB = ./lib/
JARS = $(wildcard lib/*.jar)
LIBS = .:$(LIB):$(OBJ):$(shell echo '$(JARS)' | sed 's/jar /jar:/g')

define make-target
    @javac -classpath $(LIBS) $< -d $(OBJ) $*
endef

all: always ./obj/jseshtext.class run

./obj/jseshtext.class: ./src/jseshtext.java
	$(make-target)

run:
	@java -classpath $(LIBS) jseshtext

.PHONY: clean always
	
clean:
	@rm -rf $(OBJ)

veryclean: clean
	@rm -f text/*.png
	
always:
	@mkdir -p $(OBJ)