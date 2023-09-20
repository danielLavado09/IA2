ejecutar :- hipotesis(Animal), write('El animal es: '), write(Animal), nl, undo.

% Hipótesis 
hipotesis(jaguar) :- jaguar, !.
hipotesis(oso_de_anteojos) :- oso_de_anteojos, !.
hipotesis(puma) :- puma, !.
hipotesis(tapir) :- tapir, !.
hipotesis(ocelote) :- ocelote, !.
hipotesis(aguila_arpia) :- aguila_arpia, !.
hipotesis(perico_carisucio) :- perico_carisucio, !.
hipotesis(flamenco) :- flamenco, !.
hipotesis(cotinga) :- cotinga, !.
hipotesis(loro_real_amazonico) :- loro_real_amazonico, !.
hipotesis(tortuga_charapa) :- tortuga_charapa, !.
hipotesis(cocodrilo_de_tumbes) :- cocodrilo_de_tumbes, !.
hipotesis(iguana_verde) :- iguana_verde, !.
hipotesis(serpiente_coral) :- serpiente_coral, !.
hipotesis(caiman_de_anteojos) :- caiman_de_anteojos, !.
hipotesis(salamandra_andina) :- salamandra_andina, !.
hipotesis(sapo_corredor) :- sapo_corredor, !.
hipotesis(rana_de_cristal) :- rana_de_cristal, !.
hipotesis(sapo_pintado) :- sapo_pintado, !.
hipotesis(sapo_diminuto_de_hojarasca) :- sapo_diminuto_de_hojarasca, !. 
hipotesis(pez_payaso) :- pez_payaso, !.
hipotesis(pez_sierra) :- pez_sierra, !.
hipotesis(dorado) :- dorado, !.
hipotesis(piraña) :- piraña, !.
hipotesis(delfin_rosado) :- delfin_rosado, !.
hipotesis(desconocido).

% Lista de animales

% Mamíferos
jaguar :- mamifero, carnivoro, verificar(tiene_manchas), verificar(tiene_mordida_poderosa).
oso_de_anteojos :- mamifero, herbivoro, verificar(trepa_arboles), verificar(es_solitario).
puma :- mamifero, carnivoro, verificar(es_nocturno), verificar(es_solitario).
tapir :- mamifero, herbivoro, verificar(tiene_nariz_prensil), verificar(dispersa_semillas).
ocelote :- mamifero, carnivoro, verificar(es_nocturno), verificar(depredador_de_emboscada).

% Aves
aguila_arpia :- ave, verificar(es_rapaz), verificar(tiene_reproduccion_lenta).
perico_carisucio :- ave, verificar(es_pequeño), verificar(dispersa_semillas).
flamenco :- ave, verificar(tiene_patas_largas), verificar(tiene_cuello_largo), verificar(tiene_color_rosado).
cotinga :- ave, verificar(tiene_plumaje_colorido), verificar(es_territorial), verificar(dispersa_semillas).
loro_real_amazonico :- ave, verificar(es_sociable), verificar(tiene_cabeza_amarilla), verificar(tiene_plumaje_verde).

% Reptiles
tortuga_charapa :- reptil, verificar(anida_en_playas), verificar(es_longevo).
cocodrilo_de_tumbes :- reptil, verificar(es_grande), verificar(es_sigiloso).
iguana_verde :- reptil, verificar(tiene_espinas_dorsales), verificar(es_territorial).
serpiente_coral :- reptil, verificar(tiene_colores_aposematicos), verificar(es_nocturno).
caiman_de_anteojos :- reptil, verificar(es_pequeño), verificar(es_sigiloso).

% Anfibios
salamandra_andina :- anfibio, verificar(tiene_forma_alargada).
sapo_corredor :- anfibio, verificar(tiene_reproduccion_explosiva), verificar(es_venenoso).
rana_de_cristal :- anfibio, verificar(tiene_piel_transparente), verificar(depende_de_la_humedad).
sapo_pintado :- anfibio, verificar(es_territorial), verificar(tiene_color_llamativo), verificar(depende_de_la_humedad).
sapo_diminuto_de_hojarasca :- anfibio, verificar(tiene_reproduccion_explosiva), verificar(depende_de_la_humedad).

% Peces
pez_payaso :- pez, verificar(es_de_agua_salada), verificar(vive_en_familia).
pez_sierra :- pez, verificar(es_de_agua_salada), verificar(es_longevo), verificar(tiene_nariz_en_forma_de_sierra).
dorado :- pez, verificar(es_de_agua_dulce), verificar(tiene_color_dorado).
piraña :- pez, verificar(es_de_agua_dulce), verificar(tiene_dulces_afilados).
delfin_rosado :- pez, verificar(es_de_agua_dulce), verificar(es_sociable), verificar(tiene_color_rosado).


% Clasificaciones generales
sangre_fria :- verificar(tiene_sangre_fria), !.
sangre_caliente :- verificar(tiene_sangre_caliente), !.
carnivoro :- verificar(come_carne), !.
herbivoro :- verificar(come_plantas) , !.

% Mamíferos
mamifero :- sangre_caliente, verificar(tiene_glandulas_mamarias), verificar(tiene_pelo), !.
% Aves 
ave :- sangre_caliente, verificar(tiene_plumas), !.
% Reptiles
reptil :- sangre_fria, verificar(tiene_escamas), !.
% Anfibios 
anfibio :- sangre_fria, verificar(tiene_piel_permeable), !.
% Peces 
pez :- sangre_fria, verificar(tiene_branquias), verificar(tiene_aletas), !.

% Preguntar
preguntar(Pregunta) :- 
        write('¿Tiene el animal el siguiente atributo: '), 
        write(Pregunta), write('? '), 
         read(Respuesta), nl, 
         ( (Respuesta == si ; Respuesta == s) -> assert(yes(Pregunta)) ; 
         assert(no(Pregunta)), fail). 
:- dynamic yes/1,no/1. 

% Verificar
verificar(S) :- (yes(S) -> true ; (no(S) -> fail ; preguntar(S))). 

% Resetear las respuestas
undo :- retract(yes(_)),fail. 
undo :- retract(no(_)),fail. 
undo. 