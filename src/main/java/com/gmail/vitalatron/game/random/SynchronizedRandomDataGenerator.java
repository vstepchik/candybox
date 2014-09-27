package com.gmail.vitalatron.game.random;

import org.apache.commons.math3.exception.*;
import org.apache.commons.math3.random.RandomDataGenerator;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Collection;

public class SynchronizedRandomDataGenerator extends RandomDataGenerator {

    @Override
    public synchronized String nextHexString(int len) throws NotStrictlyPositiveException {
        return super.nextHexString(len);
    }

    @Override
    public synchronized long nextSecureLong(long lower, long upper) throws NumberIsTooLargeException {
        return super.nextSecureLong(lower, upper);
    }

    @Override
    public synchronized Object[] nextSample(Collection<?> c, int k) throws NumberIsTooLargeException,
            NotStrictlyPositiveException {
        return super.nextSample(c, k);
    }

    @Override
    public synchronized double nextT(double df) throws NotStrictlyPositiveException {
        return super.nextT(df);
    }

    @Override
    public synchronized double nextUniform(double lower, double upper) throws NumberIsTooLargeException,
            NotFiniteNumberException, NotANumberException {
        return super.nextUniform(lower, upper);
    }

    @Override
    public synchronized void reSeed(long seed) {
        super.reSeed(seed);
    }

    @Override
    public synchronized int nextPascal(int r, double p) throws NotStrictlyPositiveException, OutOfRangeException {
        return super.nextPascal(r, p);
    }

    @Override
    public synchronized int nextHypergeometric(int populationSize, int numberOfSuccesses, int sampleSize)
            throws NotPositiveException, NotStrictlyPositiveException, NumberIsTooLargeException {
        return super.nextHypergeometric(populationSize, numberOfSuccesses, sampleSize);
    }

    @Override
    public synchronized long nextLong(long lower, long upper) throws NumberIsTooLargeException {
        return super.nextLong(lower, upper);
    }

    @Override
    public synchronized int nextBinomial(int numberOfTrials, double probabilityOfSuccess) {
        return super.nextBinomial(numberOfTrials, probabilityOfSuccess);
    }

    @Override
    public synchronized int nextSecureInt(int lower, int upper) throws NumberIsTooLargeException {
        return super.nextSecureInt(lower, upper);
    }

    @Override
    public synchronized double nextChiSquare(double df) {
        return super.nextChiSquare(df);
    }

    @Override
    public synchronized long nextPoisson(double mean) throws NotStrictlyPositiveException {
        return super.nextPoisson(mean);
    }

    @Override
    public synchronized double nextCauchy(double median, double scale) {
        return super.nextCauchy(median, scale);
    }

    @Override
    public synchronized void reSeedSecure() {
        super.reSeedSecure();
    }

    @Override
    public synchronized double nextGaussian(double mu, double sigma) throws NotStrictlyPositiveException {
        return super.nextGaussian(mu, sigma);
    }

    @Override
    public synchronized int[] nextPermutation(int n, int k) throws NumberIsTooLargeException,
            NotStrictlyPositiveException {
        return super.nextPermutation(n, k);
    }

    @Override
    public synchronized void reSeed() {
        super.reSeed();
    }

    @Override
    public synchronized double nextWeibull(double shape, double scale) throws NotStrictlyPositiveException {
        return super.nextWeibull(shape, scale);
    }

    @Override
    public synchronized double nextF(double numeratorDf, double denominatorDf) throws NotStrictlyPositiveException {
        return super.nextF(numeratorDf, denominatorDf);
    }

    @Override
    public synchronized int nextZipf(int numberOfElements, double exponent) throws NotStrictlyPositiveException {
        return super.nextZipf(numberOfElements, exponent);
    }

    @Override
    public synchronized int nextInt(int lower, int upper) throws NumberIsTooLargeException {
        return super.nextInt(lower, upper);
    }

    @Override
    public synchronized double nextExponential(double mean) throws NotStrictlyPositiveException {
        return super.nextExponential(mean);
    }

    @Override
    public synchronized void setSecureAlgorithm(String algorithm, String provider) throws NoSuchAlgorithmException,
            NoSuchProviderException {
        super.setSecureAlgorithm(algorithm, provider);
    }

    @Override
    public synchronized void reSeedSecure(long seed) {
        super.reSeedSecure(seed);
    }

    @Override
    public synchronized double nextGamma(double shape, double scale) throws NotStrictlyPositiveException {
        return super.nextGamma(shape, scale);
    }

    @Override
    public synchronized double nextBeta(double alpha, double beta) {
        return super.nextBeta(alpha, beta);
    }

    @Override
    public synchronized double nextUniform(double lower, double upper, boolean lowerInclusive)
            throws NumberIsTooLargeException, NotFiniteNumberException, NotANumberException {
        return super.nextUniform(lower, upper, lowerInclusive);
    }

    @Override
    public synchronized String nextSecureHexString(int len) throws NotStrictlyPositiveException {
        return super.nextSecureHexString(len);
    }
}
