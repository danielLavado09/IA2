package org.ia;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Controller {

    public void showResults() {
        List<Row> rows = readRowsFromCSV("../Datos formateados.csv");
        Integer totalValues = rows.size();
        Integer successfulPredictions = 0;
        for (Row row: rows) {
            String prediction = predict(row);
            String isFire = row.getClasses().trim();
            boolean isRightPrediction = Objects.equals(isFire, prediction);
            System.out.println(row + " " + row.getClasses() + " " + prediction + " " + isRightPrediction);
            if (isRightPrediction) {
                successfulPredictions += 1;
            }
        }
        System.out.println("Porcentaje de aciertos: " + (float) successfulPredictions/totalValues*100);
    }

    public String predict(Row r) {
        String res = "";
        if (r.getTemperature() < 31.5) {
            if (r.getRH() < 73.5) {
                if (r.getWs() < 14.5) {
                    if (r.getRain() < 0.05) {
                        if (r.getFFMC() < 84.35) {
                            if (r.getDMC() < 5.9) {
                                if (r.getDC() < 18.95) {
                                    res = "not fire";
                                } else {
                                    res = "fire";
                                }
                            } else {
                                if (r.getDC() < 20.9) {
                                    res = "not fire";
                                } else {
                                    res = "fire";
                                }
                            }
                        } else {
                            res = "fire";
                        }
                    } else {
                        if (r.getFFMC() < 62.85) {
                            res = "not fire";
                        } else {
                            if (r.getDMC() < 17.95) {
                                res = "not fire";
                            } else {
                                res = "fire";
                            }
                        }
                    }
                } else {
                    if (r.getRain() < 0.05) {
                        if (r.getFFMC() < 86.75) {
                            if (r.getDMC() < 8.95) {
                                if(r.getDC() < 17) {
                                    res = "not fire";
                                } else {
                                    res = "fire";
                                }
                            } else {
                                if (r.getDC() < 51.05) {
                                    if (r.getISI() < 4) {
                                        res = "not fire";
                                    } else {
                                        res = "fire";
                                    }
                                } else {
                                    res = "fire";
                                }
                            }
                        } else {
                            res = "fire";
                        }
                    } else {
                        res = "not fire";
                    }
                }
            } else {
                if (r.getWs() < 15.5) {
                    if (r.getRain() < 0.35) {
                        if (r.getFFMC() < 78.05) {
                            res = "not fire";
                        } else {
                            res = "fire";
                        }
                    } else {
                        res = "not fire";
                    }
                } else {
                    if (r.getRain() < 0.45) {
                        if (r.getFFMC() < 74.6) {
                            res = "not fire";
                        } else {
                            if (r.getDMC() < 12.65) {
                                if (r.getDC() < 26.3) {
                                    res = "fire";
                                } else {
                                    res = "not fire";
                                }
                            } else {
                                res = "fire";
                            }
                        }
                    } else {
                        res = "not fire";
                    }
                }
            }
        } else {
            if (r.getRH() < 54.5) {
                if (r.getWs() < 14.5) {
                    if (r.getRain() < 0.05) {
                        if (r.getFFMC() < 90.65) {
                            if (r.getDMC() < 11.25) {
                                if (r.getDC() < 20.5) {
                                    res = "not fire";
                                } else {
                                    res = "fire";
                                }
                            } else {
                                res = "fire";
                            }
                        } else {
                            res = "fire";
                        }
                    } else {
                        if (r.getFFMC() < 82.5) {
                            res = "not fire";
                        } else {
                            res = "fire";
                        }
                    }
                } else {
                    if (r.getRain() < 0.05) {
                        res = "fire";
                    } else {
                        if (r.getFFMC() < 85.15) {
                            if (r.getDMC() < 10.9) {
                                if (r.getDC() < 9.6) {
                                    res = "not fire";
                                } else {
                                    res = "fire";
                                }
                            } else {
                                if (r.getDC() < 26.8) {
                                    res = "not fire";
                                } else {
                                    res = "fire";
                                }
                            }
                        } else {
                            res = "fire";
                        }
                    }
                }
            } else {
                if (r.getWs() < 14.5) {
                    if (r.getRain() < 0.1) {
                        if (r.getFFMC() < 86.9) {
                            if (r.getDMC() < 8.25) {
                                if (r.getDC() < 19.25) {
                                    res = "not fire";
                                } else {
                                    res = "fire";
                                }
                            } else {
                                res = "fire";
                            }
                        } else {
                            res = "fire";
                        }
                    } else {
                        if (r.getFFMC() < 71.75) {
                            res = "not fire";
                        } else {
                            if (r.getDMC() < 9.3) {
                                res = "not fire";
                            } else {
                                if (r.getDC() < 90.25) {
                                    res = "not fire";
                                } else {
                                    if (r.getISI() < 2.9) {
                                        res = "fire";
                                    } else {
                                        res = "not fire";
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (r.getRain() < 0.05) {
                        if (r.getFFMC() < 87.1) {
                            if (r.getDMC() < 18.75) {
                                if (r.getDC() < 42.9) {
                                    if (r.getISI() < 4.05) {
                                        if (r.getBUI() < 7.8) {
                                            res = "not fire";
                                        } else {
                                            res = "fire";
                                        }
                                    } else {
                                        if (r.getBUI() < 12.2) {
                                            res = "not fire";
                                        } else {
                                            res = "fire";
                                        }
                                    }
                                } else {
                                    res = "fire";
                                }
                            } else {
                                res = "fire";
                            }
                        } else {
                            res = "fire";
                        }
                    } else {
                        if (r.getFFMC() < 80.1) {
                            res = "not fire";
                        } else {
                            res = "fire";
                        }
                    }
                }
            }
        }
        return res;
    }

    private List<Row> readRowsFromCSV(String fileName) {
        List<Row> rows = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            String line = br.readLine();

            while (line != null) {

                String[] attributes = line.split(",");

                Row row = createRow(attributes);

                rows.add(row);

                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return rows;
    }

    private Row createRow(String[] metadata) {
        Integer day = Integer.valueOf(metadata[0]);
        Integer month = Integer.valueOf(metadata[1]);
        Integer year = Integer.valueOf(metadata[2]);
        Float temperature = Float.valueOf(metadata[3]);
        Float rh = Float.valueOf(metadata[4]);
        Float ws = Float.valueOf(metadata[5]);
        Float rain = Float.valueOf(metadata[6]);
        Float ffmc = Float.valueOf(metadata[7]);
        Float dmc = Float.valueOf(metadata[8]);
        Float dc = Float.valueOf(metadata[9]);
        Float isi = Float.valueOf(metadata[10]);
        Float bui = Float.valueOf(metadata[11]);
        Float fwi = Float.valueOf(metadata[12]);
        String classes = metadata[13];

        return new Row(day, month, year, temperature, rh, ws, rain, ffmc, dmc, dc, isi, bui, fwi, classes);
    }

}
