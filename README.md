# JSesh sample


This is a little sample to use JSesh as a pseudo command line program.

JSesh is a  an Open Source Hieroglyphic Editor [https://jsesh.qenherkhopeshef.org](https://jsesh.qenherkhopeshef.org) and it's used to write egyptian hieroglyphs in a WYSIWYG editor using "The Manuel de Codage, abbreviated MdC, is a standard system for the computer-encoding of transliterations of Egyptian hieroglyphic texts." (from Wikipedia).

This little example uses the idea from the [JSesh site](https://jsesh.qenherkhopeshef.org/en/node/1057) to execute JSesh as a library.

## Usage

It's created to works in a vagrant enviroment (you need vagrant before) [https://www.vagrantup.com](https://www.vagrantup.com)

```
git clone https://github.com/jare/jsesh_sample.git
cd sesh_sample
vagrant up
```

When the vagrant enviroment is up:

```
vagrant ssh 
cd /vagrant
make all
```

and you can see something like : 

```
vagrant@linux:/vagrant$ make all
Engraving hieroglyph: text/sample1.png
Engraving hieroglyph: text/sample2.png
Engraving hieroglyph: text/sample3.png
Engraving hieroglyph: text/sample4.png
Engraving hieroglyph: text/sample5.png
```

this means that in the text directory there are created the new PNG images 

## License 

JSesh sample is free software/open source, and is distributed under the BSD license. It contains third-party code in lib director, libraries from JSesh 

## References

Rosmorduc, Serge. JSesh - [https://jsesh.qenherkhopeshef.org](https://jsesh.qenherkhopeshef.org) 
