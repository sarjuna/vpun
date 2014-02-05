LATEX = latex
BIBTEX = bibtex
PDFLATEX = pdflatex
METAPOST = mpost
DVIPS = dvips -P cmz -t letter 
#DVIPS = dvips -j0 -t a4
PS2PDF = ps2pdf -dEmbedAllFonts=true

.SUFFIXES: pdf ps dvi tex

# automatically generate eps file from figs
FIGS = figures/overview.eps

# used for non generated eps files
EPSONLY = 

# automatically generate eps file from gnuplot file
RESULTS = 

# tex sources for the paper
TEXSRCS = paper.tex

all: cleanpaper ps pdf 
dvi: paper.dvi 
ps: paper.ps 
pdf: paper.pdf 

paper.pdf: paper.ps
	$(PS2PDF) $< $@
paper.ps: paper.dvi
	$(DVIPS) $< -o $@
paper.dvi: 
#$(FIGS) $(RESULTS) $(TEXSRCS) $(EPSONLY) ./biblio.bib
	$(PDFLATEX) paper.tex
#	$(BIBTEX) -min-crossrefs=100 paper
	$(PDFLATEX) paper.tex	
#       $(LATEX) paper.tex

clean: cleanpaper
	rm -f x.log

tidy: cleanpaper
	rm -f *~ x.log
cleanpaper:
	rm -f paper.ps paper.pdf paper.dvi paper.aux paper.log paper.bbl paper.blg 
cleanfig:
	/bin/rm -f $(FIGS) $(RESULTS) fig/*.log fig/*.aux fig/*.dvi fig/*.mpx

%.eps : %.plt
	gnuplot $< 

%.eps : %.fig
	fig2dev -L eps $< > $@

help:
	@echo "make tidy : cleans all automatically generated files and figures"
	@echo "make clean : cleans only latex generated files"
	@echo "make all : builds the paper"
